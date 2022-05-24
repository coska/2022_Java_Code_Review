/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex01.filterbypredicate.flaw;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils1 {

	public List<Integer> getOddNumbers(List<Integer> numbers) {
		final List<Integer> result = new ArrayList<>();
		for (Integer number : numbers) {
			if (number == null) {
				continue;
			}
			if (number % 2 != 0) {
				result.add(number);
			}
		}
		return result;
	}

	public List<Integer> getEvenNumbers(List<Integer> numbers) {
		final List<Integer> result = new ArrayList<>();
		for (Integer number : numbers) {
			if (number == null) {
				continue;
			}
			if (number % 2 == 0) {
				result.add(number);
			}
		}
		return result;
	}
}
