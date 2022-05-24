/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex12.forvsstream.functional;

import java.util.Arrays;

public enum ProductType {

	DDA, CREDIT_CARD, HELOC;

	public static ProductType of(String type) {
		return Arrays.stream(ProductType.values())
				.filter(productType -> productType.name().equalsIgnoreCase(type))
				.findFirst()
				.orElse(null);
	}
}

//TODO test & compare the performance, you will find out Stream is no longer slow since Java 11