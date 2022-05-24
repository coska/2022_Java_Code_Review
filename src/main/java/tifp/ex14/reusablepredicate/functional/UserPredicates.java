/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPredicates {

	public static final Predicate<UserDto> IS_VIEWER = userDto -> {
		System.out.println("trying isViewer...");   //just to trace the predicate evaluations
		return userDto.isViewer();
	};
	public static final Predicate<UserDto> IS_WRITER = userDto -> {
		System.out.println("trying isWriter...");   //just to trace the predicate evaluations
		return userDto.isWriter();
	};
	public static final Predicate<UserDto> IS_ADMIN = userDto -> {
		System.out.println("trying isAdmin...");   //just to trace the predicate evaluations
		return userDto.isAdmin();
	};
}
