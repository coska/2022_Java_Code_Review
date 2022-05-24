/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex04.pipeline.functional;

import java.util.function.Consumer;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;
import tifp.ex04.pipeline.Identifier;
import tifp.ex04.pipeline.IdentifierMapper;
import tifp.ex04.pipeline.Person;
import tifp.ex04.pipeline.PersonService;
import tifp.ex04.pipeline.Printer;

@Slf4j
public class Processor {

	private final PersonService personService = new PersonService();
	private final IdentifierMapper identifierMapper = new IdentifierMapper();
	private final Printer printer = new Printer();

	//For sure, following functions can be reusable being placed somewhere out there.
	public final Function<String, Person> findPerson = personService::findById;
	public final Function<Person, Identifier> toIdentifier = identifierMapper::map;
	public final Consumer<Identifier> print = printer::print;

	public void process(String id) {
		final Person person = findPerson.apply(id);
		final Identifier identifier = toIdentifier.apply(person);
		print.accept(identifier);

		//1. Let's try doing inline variables above, but the readability doesn't get better much
		//============== >>>
		print.accept(toIdentifier.apply(findPerson.apply(id)));

		//2. Compare with following, 'pipeline them' by function APIs, andThen()/compose().
		print.accept(
				findPerson
						.andThen(toIdentifier)
						.apply(id));
	}
}
