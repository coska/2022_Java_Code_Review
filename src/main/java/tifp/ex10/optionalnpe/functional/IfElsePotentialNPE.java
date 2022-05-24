/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex10.optionalnpe.functional;

import java.util.Optional;

import lombok.Data;

public class IfElsePotentialNPE {

	public String uppercase(Property property, String expectedName) {

		return Optional.ofNullable(property)
				.filter(p -> expectedName.equalsIgnoreCase(p.getName()))
				.map(Property::getValue)
				.map(String::toUpperCase)
				.orElse(null);
	}

	@Data
	private static class Property {
		private String name;
		private String value;
	}
}
