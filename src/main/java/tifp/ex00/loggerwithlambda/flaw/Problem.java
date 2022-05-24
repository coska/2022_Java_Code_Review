/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex00.loggerwithlambda.flaw;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Problem {

	public static void main(String[] args) {
		//what's wrong here? getPositiveIntegers() is always invoked regardless.
		log.debug("Print even numbers... {}", getPositiveIntegers());
	}

	private static List<Integer> getPositiveIntegers() {
		return IntStream.range(1, Integer.MAX_VALUE)
				.filter(number -> number % 2 == 0)
				.boxed()
				.collect(Collectors.toList());
	}
}
