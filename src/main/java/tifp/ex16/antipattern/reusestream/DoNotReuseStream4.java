/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex16.antipattern.reusestream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DoNotReuseStream4 {

	//So, my suggestion is "COMPROMISE".
	//You may give up some code redundancies, but certainly save much more time when it comes to code-reads.

	public static void main(String[] args) {
		final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

		final List<String> uppercased = collection.stream()
				.filter(StringUtils::isAlpha)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		log.debug("Uppercased: {}", uppercased);

		final List<String> lowercased = collection.stream()
				.filter(StringUtils::isAlpha)
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		log.debug("Lowercased: {}", lowercased);
	}
}