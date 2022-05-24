/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex06.enumwithfunction.before;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import tifp.ex06.enumwithfunction.PriceRepository;
import tifp.ex06.enumwithfunction.Product;

@RequiredArgsConstructor
public class PriceService {

	private final PriceRepository priceRepository;

	public BigDecimal getPrice(SalesType salesType, Product product) {
		if (salesType == SalesType.REGULAR) {
			return priceRepository.getRegularPriceFor(product);
        }
        if (salesType == SalesType.PROMOTION) {
			return priceRepository.getPromoPriceFor(product);
        }
		throw new UnsupportedOperationException(String.format("Sales type [%s] is not supported.", salesType.name()));
	}
}
