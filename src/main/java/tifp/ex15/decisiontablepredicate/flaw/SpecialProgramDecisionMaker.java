/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex15.decisiontablepredicate.flaw;

import tifp.ex15.decisiontablepredicate.Person;
import tifp.ex15.decisiontablepredicate.SpecialProgram;
import tifp.ex15.decisiontablepredicate.Status;

public class SpecialProgramDecisionMaker {

	public SpecialProgram getSpecialProgram(Person person) {
		final Status status = person.getStatus();
		final int age = person.getAge();
		if (status == Status.CITIZEN) {
			if (age < 8) {
				return SpecialProgram.A;
			}
			if (age <= 18) {
				return SpecialProgram.B;
			}
			if (age < 60) {
				return SpecialProgram.C;
			}
			return SpecialProgram.B;

		} else if (status == Status.WORK_PERMIT) {
			if (age < 8) {
				return SpecialProgram.B;
			}
			if (age <= 18) {
				return SpecialProgram.C;
			}
			if (age < 60) {
				return SpecialProgram.D;
			}
			return SpecialProgram.C;

		} else if (status == Status.VISITOR) {
			if (age < 8) {
				return SpecialProgram.B;
			}
			if (age <= 18) {
				return SpecialProgram.D;
			}
			if (age < 60) {
				return SpecialProgram.N_A;
			}
			return SpecialProgram.D;
		}
		throw new IllegalArgumentException("Person has not valid status: " + status);
	}
}
