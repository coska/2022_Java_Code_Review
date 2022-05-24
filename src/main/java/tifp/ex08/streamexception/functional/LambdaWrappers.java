/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex08.streamexception.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 이렇게 유틸리티로 만들면 재사용성이 좋아지겠죠?
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LambdaWrappers {

	//Exception handling with Predicate in particular
	public static <T, E extends Exception> Predicate<T> wrap(Predicate<T> predicate, Class<E> ignored) {
		return in -> {
			try {
				return predicate.test(in);

			} catch (Exception e) {
				try {
					final E castedException = ignored.cast(e);
					//handle the ignored exception
					System.out.println("Ignored " + castedException.getClass().getSimpleName() + " when the input is " + in);
					return false;

				} catch (ClassCastException cce) {
					//handle it, or throw it as-is/transformed
					throw e;
				}
			}
		};
	}
}
