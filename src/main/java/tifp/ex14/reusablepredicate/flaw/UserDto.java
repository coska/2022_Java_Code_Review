/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate.flaw;

import lombok.Data;
import tifp.ex14.reusablepredicate.AuthType;

@Data
public class UserDto {

	private String id;
	private AuthType authType;
}
