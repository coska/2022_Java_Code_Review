/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex07.consumerexception.functional;

import java.util.function.BiConsumer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LambdaWrappers {

	public static <T, V> BiConsumer<T, V> wrap(BiConsumer<T, V> consumer) {
		return (T t, V v) -> {
			try {
				consumer.accept(t, v);
			} catch (Exception e) {
				System.out.println(e);
				//do something...
			}
		};
	}

	public static <T, V, E extends Exception> BiConsumer<T, V> wrap(BiConsumer<T, V> consumer, Class<E> ignored) {
		return (number, arg) -> {
			try {
				consumer.accept(number, arg);

			} catch (Exception e) {
				try {
					ignored.cast(e);
					System.out.println("Ignored ... " + ignored.cast(e).getClass().getSimpleName());

				} catch (ClassCastException cce) {
					System.out.println(e);
					throw e;
				}
			}
		};
	}
}
