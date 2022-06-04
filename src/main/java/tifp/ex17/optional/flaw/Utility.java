/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex17.optional.flaw;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.Objects;

public class Utility {

	public Object halfRoundUp(Object input) {
		final String valueInString = Objects.toString(input, "").trim();
		if (!valueInString.isEmpty()) {
			final BigDecimal number = new BigDecimal(valueInString);
			if (number.scale() > 2) {
				return number.setScale(2, HALF_UP).toString();
			}
		}
		return input;
	}
}
