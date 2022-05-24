/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex04.pipeline.flaw;

import tifp.ex04.pipeline.Identifier;
import tifp.ex04.pipeline.IdentifierMapper;
import tifp.ex04.pipeline.Person;
import tifp.ex04.pipeline.PersonService;
import tifp.ex04.pipeline.Printer;

public class Processor {

	private final PersonService personService = new PersonService();
	private final IdentifierMapper mapper = new IdentifierMapper();
	private final Printer printer = new Printer();

	public void process(String id) {
		final Person person = personService.findById(id);
		final Identifier identifier = mapper.map(person);
		printer.print(identifier);
	}
}
//Explain how these steps become "pipelined".
