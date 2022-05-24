/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex07.consumerexception.flaw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.BiConsumer;

public class CalculatorTryCatch {

	public static void main(String[] args) {

		//Let's assume this argument is provided in runtime... and here we have ZERO!!
		final List<BigDecimal> denominators = List.of(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.valueOf(2.0), BigDecimal.valueOf(3));

		//Divide
		final BigDecimal numerator = BigDecimal.valueOf(2);
		calculate(denominators, numerator, (denominator, arg) ->
				System.out.printf("* %s/%s = %s%n", arg, denominator, arg.divide(denominator, RoundingMode.HALF_UP)));
	}

	public static void calculate(List<BigDecimal> numbers, BigDecimal argument, BiConsumer<BigDecimal, BigDecimal> consumer) {
		//계산중 exception이 생길 수 있다는 것을 알고, try-catch를 하려는데, 무엇이 잘못일까?
		//Let's run this!
		try {
			for (BigDecimal number : numbers) {
				consumer.accept(number, argument);
			}
		} catch(Exception e) {
			System.out.println(e);
			//do something...
		}
	}
}
//Fix: Can we handle the exception but still make it execute for ALL ELEMENTS without an interim termination?
