/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex08.streamexception.flaw;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorTryCatch {

	public static void main(String[] args) {
		//Let's assume this argument is provided in runtime...
		final List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

		try {
			numbers.stream()
					.filter(CalculatorTryCatch::isPrime)
					.collect(Collectors.toList())
					.forEach(number -> System.out.println(number + " is a prime number."));

		} catch(IllegalArgumentException e) {
			//Exception got skipped, but it stops immediately :(
			//Goal: can we continue stream processing?
			System.out.println(e);
		}
	}

	static boolean isPrime(Integer number) {
		//This kind of validation is very typical, but see what unexpected result occurs. Run the main().
		if (number == null|| number < 1) {
			throw new IllegalArgumentException("The input number " + number + " is not a positive integer.");
		}
		return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
	}
}