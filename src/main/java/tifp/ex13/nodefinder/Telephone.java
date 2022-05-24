/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex13.nodefinder;

import lombok.Data;

@Data
public
class Telephone {

	private PhoneType phoneType;
	private String areaCode;
	private String number;
}
