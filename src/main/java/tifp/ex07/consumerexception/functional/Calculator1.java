/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex07.consumerexception.functional;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.BiConsumer;

public class Calculator1 {

	public static void main(String[] args) {
		//Let's assume this argument is provided in runtime...
		final List<BigDecimal> denominators = List.of(ONE, ZERO, BigDecimal.valueOf(2.0), BigDecimal.valueOf(3));

		//Divide
		final BigDecimal numerator = BigDecimal.valueOf(2);
		calculate(denominators, numerator,

				//This wrapper is the key where an exception is being handled gracefully.
				wrap((denominator, arg) ->
						System.out.printf("* %s/%s = %s%n", arg, denominator, arg.divide(denominator, RoundingMode.HALF_UP))));
	}

	public static void calculate(List<BigDecimal> numbers, BigDecimal variable, BiConsumer<BigDecimal, BigDecimal> consumer) {
		for (BigDecimal number : numbers) {
			consumer.accept(number, variable);
		}
	}

	static BiConsumer<BigDecimal, BigDecimal> wrap(BiConsumer<BigDecimal, BigDecimal> consumer) {
		return (number, arg) -> {
			try {
				consumer.accept(number, arg);
			} catch (Exception e) {
				System.out.println(e);
				//Do something ...
			}
		};
	}
}
