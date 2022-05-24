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
public class NumberUtils2 {

	//조금이라도 중복 코드를 줄여보려고 애써보면...

	public List<Integer> getOddNumbers(List<Integer> numbers) {
		return getOddOrEvenNumbers(numbers, 1);
	}

	public List<Integer> getEvenNumbers(List<Integer> numbers) {
		return getOddOrEvenNumbers(numbers, 0);
	}

	private List<Integer> getOddOrEvenNumbers(List<Integer> numbers, int remainder) {
		final List<Integer> result = new ArrayList<>();
		for (Integer number : numbers) {
			if (number == null) {
				continue;
			}
			if (number % 2 == remainder) {
				result.add(number);
			}
		}
		return result;
	}
}
