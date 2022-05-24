/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex00.loggerwithlambda.functional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Solution {

	public static void main(String[] args) {
		log.debug("Print even numbers... {}", Solution::getPositiveIntegers);
	}

	private static List<Integer> getPositiveIntegers() {
		return IntStream.range(1, Integer.MAX_VALUE)
				.filter(number -> number % 2 == 0)
				.boxed()
				.collect(Collectors.toList());
	}
}
