/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex03.copytomap.flaw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tifp.ex03.copytomap.Person;

public class PersonUtils {

	//Person 리스트를 읽어서, 이름과 나이를 각각 새로운 Map의 key와 value에 할당하라.

	//Imperative style ...
	public Map<String, Integer> toMap(List<Person> persons) {
		final Map<String, Integer> result = new HashMap<>();
		for (Person person : persons) {
			result.put(person.getName(), person.getAge());
		}
		return result;
	}

	public Map<String, Integer> toMapWithForEach(List<Person> persons) {
		final Map<String, Integer> result = new HashMap<>();

		// 이미 살펴봤듯이, 이렇게 forEach()를 쓰는 것은 anti-pattern
		persons.forEach(person -> result.put(person.getName(), person.getAge()));

		return result;
	}
}
