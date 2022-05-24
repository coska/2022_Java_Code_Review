/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex12.forvsstream.fixed;

import java.util.Optional;

public enum ProductType {

	DDA, CREDIT_CARD, HELOC;

	public static Optional<ProductType> of(String type) {
		for (ProductType productType : values()) {
			if (productType.name().equalsIgnoreCase(type)) {    //1. name() to compare with the input String
				return Optional.of(productType);    //2. return Optional
			}
		}
		return Optional.empty();    //2. return Optional
	}
}
