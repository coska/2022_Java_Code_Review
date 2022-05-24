/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex01.filterbypredicate.functional;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListUtils {

	//Note: this method can become a reusable BiFunction as of 2 inputs and 1 output.
	public static <T> List<T> filterBy(List<T> list, Predicate<T> predicate) {
		return list.stream()
				.filter(Objects::nonNull)
				.filter(predicate)
				.collect(Collectors.toList());
	}
}