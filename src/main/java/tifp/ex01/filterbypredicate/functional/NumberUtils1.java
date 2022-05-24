/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex01.filterbypredicate.functional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils1 {

	public static List<Integer> getOddNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(Objects::nonNull)
				.filter(number -> number % 2 != 0)
				.collect(Collectors.toList());
	}

	public static List<Integer> getEvenNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(Objects::nonNull)
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());
	}

	//Is there more we can do to reduce the code redundancies between getOddNumbers() & getEvenNumbers()?
}
