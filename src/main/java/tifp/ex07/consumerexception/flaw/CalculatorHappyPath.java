/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex07.consumerexception.flaw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.BiConsumer;

public class CalculatorHappyPath {

	public static void main(String[] args) {

		//Let's assume this argument is provided in runtime...
		final List<BigDecimal> denominators = List.of(BigDecimal.ONE, BigDecimal.valueOf(2.0), BigDecimal.valueOf(3));

		//Divide
		final BigDecimal numerator = BigDecimal.valueOf(2);
		calculate(denominators, numerator, (denominator, arg) ->
				System.out.printf("* %s/%s = %s%n", arg, denominator, arg.divide(denominator, RoundingMode.HALF_UP)));
	}

	public static void calculate(List<BigDecimal> numbers, BigDecimal argument, BiConsumer<BigDecimal, BigDecimal> consumer) {
		for (BigDecimal number : numbers) {
			consumer.accept(number, argument);
		}
	}
}
