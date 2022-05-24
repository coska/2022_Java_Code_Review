/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex13.nodefinder.flaw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tifp.ex13.nodefinder.ContactInfo;
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

	private String getPhoneNumber(Person person, PhoneType phoneType) {
		final ContactInfo contactInfo = person.getContactInfo();
		if (contactInfo != null) {
			final Collection<Telephone> phoneNumbers = contactInfo.getPhoneNumbers();
			if (phoneNumbers != null) {
				for (Telephone phoneNumber : phoneNumbers) {
					if (phoneNumber.getPhoneType() == phoneType) {
						return phoneNumber.getAreaCode() + phoneNumber.getNumber();
					}
				}
			}
		}
		return null;
	}

	private String getDependentNames(Person person) {
		final List<String> result = new ArrayList<>();
		final Collection<FamilyMember> familyMembers = person.getFamilyMembers();
		if (familyMembers != null) {
			for (FamilyMember familyMember : familyMembers) {
				if (familyMember.isDependent()) {
					result.add(familyMember.getName());
				}
			}
		}
		return String.join(",", result);
	}

	private String getSiblingNames(Person source) {
		final List<String> result = new ArrayList<>();
		final Collection<FamilyMember> familyMembers = source.getFamilyMembers();
		if (familyMembers != null) {
			for (FamilyMember familyMember : familyMembers) {
				if (familyMember.getRelationType() == RelationType.SIBLING) {
					result.add(familyMember.getName());
				}
			}
		}
		return String.join(",", result);
	}
}
