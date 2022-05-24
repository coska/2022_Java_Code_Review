/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex05.decorator.flaw;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PersonMapDecorator {

	private final Logger logger = new Logger();
	private final PersonEntityMapper mapper = new PersonEntityMapper();

	// Decorator pattern: wrap with 'logger.log()'
	public void process(PersonDto personDto) {
		logger.log(personDto);
		final PersonEntity personEntity = mapper.map(personDto);
		logger.log(personEntity);
	}

	public static void main(String[] args) {
		new PersonMapDecorator().process(new PersonDto("Brendan", "Kim"));
	}
}

class Logger {

	public void log(Object input) {
		System.out.println(input);
	}
}

class PersonEntityMapper {

	public PersonEntity map(PersonDto personDto) {
		System.out.println("Mapping DTO to Entity ...");
		return new PersonEntity(personDto.getLastName() + ", " + personDto.getFirstName());
	}
}

@Data
@AllArgsConstructor
class PersonDto {
	private String firstName;
	private String lastName;
}

@Data
@AllArgsConstructor
class PersonEntity {
	private String name;
}