/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex16.antipattern.reusestream;

import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DoNotReuseStream3 {

	public static void main(String[] args) {
		final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

		//So, I don't reuse Stream here but I use a utility to still reduce some redundant codes.
		final List<String> uppercased = StreamUtils2.alphabetsOnlyAndMap(collection, String::toUpperCase)
				.collect(Collectors.toList());
		log.debug("Uppercased: {}", uppercased);

		final List<String> lowercased = StreamUtils2.alphabetsOnlyAndMap(collection, String::toLowerCase)
				.collect(Collectors.toList());
		log.debug("Lowercased: {}", lowercased);
	}
}

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StreamUtils2 {

	public static Stream<String> alphabetsOnlyAndMap(Collection<String> collection, UnaryOperator<String> unaryOperator) {
		return collection.stream()
				.filter(StringUtils::isAlpha)
				.map(unaryOperator);
	}
}

//Q: This will work, but do you see this approach and pattern benefit a lot?
//In my experiences, 99% or always... I had to go to the source code of the utility method to verify that it's what I want.
