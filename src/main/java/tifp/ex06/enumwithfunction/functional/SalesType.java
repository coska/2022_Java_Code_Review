/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex06.enumwithfunction.functional;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tifp.ex06.enumwithfunction.Product;

@RequiredArgsConstructor
@Getter
public enum SalesType {

	//Try 'replace method reference with lambda' to see what's actually happening here...
	REGULAR(PriceService::getRegularPrice),
	PROMOTION(PriceService::getPromoPrice);

	private final BiFunction<PriceService, Product, BigDecimal> priceFunction;
}
