/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex16.antipattern.reusestream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

public class DoNotReuseStream2 {

	//Let's run and see how it works!

	public static void main(String[] args) {
		final List<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

		//Purposed to reuse a Stream out of collection.
		final Stream<String> alphabetsStream = StreamUtils.alphabetsOnly(collection);

		final List<String> uppercased = alphabetsStream
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println("Uppercased: " + uppercased);

		final List<String> lowercased = alphabetsStream
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		System.out.println("Lowercased: " + lowercased);
	}
}

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StreamUtils {

	public static Stream<String> alphabetsOnly(Collection<String> collection) {
		return collection.stream()
				.filter(StringUtils::isAlpha);
	}
}