/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex04.pipeline;

public class IdentifierMapper {

	public Identifier map(Person person) {
		return new Identifier(person.getId());
	}
}
