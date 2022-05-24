/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex03.copytomap.functional;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tifp.ex03.copytomap.Person;

public class PersonUtils {

	//Person 리스트를 읽어서, 이름과 나이를 각각 새로운 Map의 key와 value에 할당하라.

	public Map<String, Integer> toMap(List<Person> persons) {
		return persons.stream()
				.map(person -> new SimpleEntry<>(person.getName(), person.getAge()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
}
