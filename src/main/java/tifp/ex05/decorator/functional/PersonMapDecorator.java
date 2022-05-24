/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex05.decorator.functional;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PersonMapDecorator {

	private final LogIt<PersonDto> logDto = new LogIt<>();
	private final MapToEntity dtoToEntity = new MapToEntity();
	private final LogIt<PersonEntity> logEntity = new LogIt<>();

	//As well, you can make a sharable Function with lambda expressions as follows.
	public static final Function<PersonDto, PersonEntity> MAP_TO_ENTITY = dto -> {
		System.out.println("mapping ...");
		return new PersonEntity(dto.getLastName() + ", " + dto.getFirstName());
	};

	public void process(PersonDto personDto) {
		logDto.andThen(dtoToEntity).andThen(logEntity).apply(personDto);
	}

	public static void main(String[] args) {
		new PersonMapDecorator().process(new PersonDto("Brendan", "Kim"));
	}
}

//Modified it to become a function - UnaryOperator (i.e. same input & output)
class LogIt<T> implements UnaryOperator<T> {
	@Override
	public T apply(T t) {
		System.out.println(t);
		return t;
	}
}

class MapToEntity implements Function<PersonDto, PersonEntity> {
	@Override
	public PersonEntity apply(PersonDto personDto) {
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