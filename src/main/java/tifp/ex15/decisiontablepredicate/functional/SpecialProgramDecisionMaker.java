/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex15.decisiontablepredicate.functional;

import static tifp.ex15.decisiontablepredicate.SpecialProgram.A;
import static tifp.ex15.decisiontablepredicate.SpecialProgram.B;
import static tifp.ex15.decisiontablepredicate.SpecialProgram.C;
import static tifp.ex15.decisiontablepredicate.SpecialProgram.D;
import static tifp.ex15.decisiontablepredicate.SpecialProgram.N_A;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.ADULT;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.CITIZEN;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.ENFANT;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.SENIOR;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.VISITOR;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.WORK_PERMIT;
import static tifp.ex15.decisiontablepredicate.functional.PersonPredicates.YOUTH;

import java.util.Map;
import java.util.function.Predicate;

import tifp.ex15.decisiontablepredicate.Person;
import tifp.ex15.decisiontablepredicate.SpecialProgram;

public class SpecialProgramDecisionMaker {

	private static final Map<Predicate<Person>, SpecialProgram> DECISION_MAP = Map.of(
			ENFANT.and(CITIZEN), A,
			ENFANT.and(YOUTH.or(SENIOR)).or(ENFANT.and(WORK_PERMIT.or(VISITOR))), B,
			ADULT.and(CITIZEN).or(WORK_PERMIT.and(YOUTH.or(SENIOR))), C,
			(VISITOR.and(YOUTH.or(SENIOR))).or(ADULT.and(WORK_PERMIT)), D
	);

	public SpecialProgram getSpecialProgram(Person person) {
		return DECISION_MAP.entrySet().stream()
				.filter(entry -> entry.getKey().test(person))
				.findFirst()
				.map(Map.Entry::getValue)
				.orElse(N_A);
	}
}
