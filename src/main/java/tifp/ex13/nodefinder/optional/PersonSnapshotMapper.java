/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex13.nodefinder.optional;

import tifp.ex13.nodefinder.FamilyMember;
import tifp.ex13.nodefinder.Person;
import tifp.ex13.nodefinder.PersonSnapshot;
import tifp.ex13.nodefinder.PhoneType;
import tifp.ex13.nodefinder.RelationType;
import tifp.ex13.nodefinder.Telephone;

public class PersonSnapshotMapper {

	public PersonSnapshot map(Person source) {
		return PersonSnapshot.builder()
				.name(source.getName())
				.homeNumber(getPhoneNumber(source, PhoneType.HOME))
				.mobileNumber(getPhoneNumber(source, PhoneType.MOBILE))
				.dependentNames(getDependentNames(source))
				.siblingNames(getSiblingNames(source))
				.build();
	}

	private String getPhoneNumber(Person source, PhoneType phoneType) {
		return NodeFinder.phoneNumber(source, telephone -> telephone.getPhoneType() == phoneType)
				.map(Telephone::getNumber)
				.orElse(null);
	}

	private String getDependentNames(Person source) {
		return String.join(",",
				NodeFinder.familyMemberNames(source, FamilyMember::isDependent));
	}

	private String getSiblingNames(Person source) {
		return String.join(",",
				NodeFinder.familyMemberNames(source, familyMember -> familyMember.getRelationType() == RelationType.SIBLING));
	}
}
