/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex06.enumwithfunction.functional;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import tifp.ex06.enumwithfunction.PriceRepository;
import tifp.ex06.enumwithfunction.Product;

@RequiredArgsConstructor
public class PriceService {

	private final PriceRepository priceRepository;

	//Note this method signature stays same.
	public BigDecimal getPrice(SalesType salesType, Product product) {
		return salesType.getPriceFunction()
				.apply(this, product);
	}

	//below 2 methods don't have to be public, but should be accessible from SalesType enum
	BigDecimal getRegularPrice(Product product) {
		return priceRepository.getRegularPriceFor(product);
	}

	BigDecimal getPromoPrice(Product product) {
		return priceRepository.getPromoPriceFor(product);
	}

}
