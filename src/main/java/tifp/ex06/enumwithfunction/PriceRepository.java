/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex06.enumwithfunction;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class PriceRepository {

	public BigDecimal getRegularPriceFor(Product product) {
		//Omitted implementation
		return BigDecimal.ONE;
	}

	public BigDecimal getPromoPriceFor(Product product) {
		//Omitted implementation
		return BigDecimal.TEN;
	}
}
