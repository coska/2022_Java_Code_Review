/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex08.streamexception.functional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

	public static void main(String[] args) {
		final List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

		numbers.stream()
				.filter(
						//The same principle here is to wrap a lambda/function and return the same signature lambda/function.
						//Additionally, you can give a hint what specific exception is ignorable.
						LambdaWrappers.wrap(Calculator::isPrime, IllegalArgumentException.class))

				.collect(Collectors.toList())
				.forEach(number -> System.out.println(number + " is a prime number."));
	}

	static boolean isPrime(Integer number) {
		//Still this validation is run. (레거시/3rd party 라이브러리라고 생각해보자)
		if (number == null|| number < 1) {
			throw new IllegalArgumentException("The input number " + number + " is not a positive integer.");
		}
		return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
	}
}

//Assignment 1: How to wrap a function?
//Assignment 2: How to separate success/failure result and even collect all the failed data?
//e.g. https://8thlight.com/blog/brian-gerstle/2019/01/22/fnl-exceptions-in-java.html
//e.g. https://medium.com/swlh/how-to-handle-exceptions-properly-within-steams-the-functional-way-f9da42c051a9