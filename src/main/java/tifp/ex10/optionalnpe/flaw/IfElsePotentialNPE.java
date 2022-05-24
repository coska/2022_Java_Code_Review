/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex10.optionalnpe.flaw;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

public class IfElsePotentialNPE {

	public String uppercaseValueIfNameIsEqual(Property property, String expectedName) {
		//Everything is nullalbe; the input Property, its 'name' or even 'value'!
		//How will you make the code simple to read and concise? The answer is Optional.
		if (property.getName().equalsIgnoreCase(expectedName)) {
			return StringUtils.upperCase(property.getValue());
		}
		return property.getValue();
	}

	@Data
	private static class Property {
		private String name;
		private String value;
	}
}
