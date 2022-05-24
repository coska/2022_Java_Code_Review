/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex13.nodefinder.optional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tifp.ex13.nodefinder.ContactInfo;
import tifp.ex13.nodefinder.FamilyMember;
import tifp.ex13.nodefinder.Person;
import tifp.ex13.nodefinder.Telephone;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NodeFinder {

	public static Collection<Telephone> telephones(Person person) {
		return Optional.ofNullable(person)
				.map(Person::getContactInfo)
				.map(ContactInfo::getPhoneNumbers)
				.orElse(Collections.emptyList());
	}

	public static Optional<Telephone> phoneNumber(Person person, Predicate<Telephone> predicate) {
		return telephones(person)
				.stream()
				.filter(predicate)
				.findFirst();
	}

	public static Collection<FamilyMember> familyMembers(Person person) {
		return Optional.ofNullable(person)
				.map(Person::getFamilyMembers)
				.orElse(Collections.emptyList());
	}

	public static Collection<String> familyMemberNames(Person person, Predicate<FamilyMember> predicate) {
		return familyMembers(person).stream()
				.filter(predicate)
				.map(FamilyMember::getName)
				.collect(Collectors.toList());
	}
}