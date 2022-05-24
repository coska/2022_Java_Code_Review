/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex01.filterbypredicate.functional;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils2 {

	public List<Integer> getOddNumbers(List<Integer> numbers) {
		return ListUtils.filterBy(numbers, number -> number % 2 != 0);
	}

	public List<Integer> getEvenNumbers(List<Integer> numbers) {
		return ListUtils.filterBy(numbers, number -> number % 2 == 0);
	}
}
