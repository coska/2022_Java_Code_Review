/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex15.decisiontablepredicate.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tifp.ex15.decisiontablepredicate.Person;
import tifp.ex15.decisiontablepredicate.Status;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonPredicates {

	public static final Predicate<Person> ENFANT = person -> person.getAge() < 8;
	public static final Predicate<Person> YOUTH = person -> person.getAge() >= 8 && person.getAge() <= 18;
	public static final Predicate<Person> ADULT = person -> person.getAge() > 18 && person.getAge() < 60;
	public static final Predicate<Person> SENIOR = person -> person.getAge() >= 60;

	public static final Predicate<Person> CITIZEN = person -> person.getStatus() == Status.CITIZEN;
	public static final Predicate<Person> WORK_PERMIT = person -> person.getStatus() == Status.WORK_PERMIT;
	public static final Predicate<Person> VISITOR = person -> person.getStatus() == Status.VISITOR;
}
