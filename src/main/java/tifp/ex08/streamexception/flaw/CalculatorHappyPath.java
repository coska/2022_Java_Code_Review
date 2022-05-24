/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex08.streamexception.flaw;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorHappyPath {

	public static void main(String[] args) {
		//Let's assume this argument is provided in runtime...
		final List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

		numbers.stream()
				.filter(CalculatorHappyPath::isPrime)
				.collect(Collectors.toList())
				.forEach(number -> System.out.println(number + " is a prime number."));
	}

	//Looks like it works, but should we not need a validation to make sure the input's purity?
	static boolean isPrime(Integer number) {
		return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
	}
}