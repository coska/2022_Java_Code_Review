/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex04.pipeline;

public class PersonService {

	public Person findById(String id) {
		//assume it is trying to fetch from somewhere...
		return new Person(id);
	}
}
