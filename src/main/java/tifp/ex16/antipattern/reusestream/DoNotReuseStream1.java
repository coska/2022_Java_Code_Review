/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex16.antipattern.reusestream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class DoNotReuseStream1 {

	public static void main(String[] args) {
		final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

		final List<String> uppercasedAlphabets = collection.stream()
				.filter(StringUtils::isAlpha)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println("Uppercased: " + uppercasedAlphabets);

		final List<String> lowercasedAlphabets = collection.stream()
				.filter(StringUtils::isAlpha)
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		System.out.println("Lowercased: " + lowercasedAlphabets);
	}
}

//I have the redundant codelet ===========> collection.stream().filter(StringUtils::isAlpha)
//Should I localize the common codes?