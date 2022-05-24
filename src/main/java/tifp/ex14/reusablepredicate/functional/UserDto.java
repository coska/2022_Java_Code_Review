/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate.functional;

import static tifp.ex14.reusablepredicate.AuthType.ADMIN;
import static tifp.ex14.reusablepredicate.AuthType.VIEWER;
import static tifp.ex14.reusablepredicate.AuthType.WRITER;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tifp.ex14.reusablepredicate.AuthType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String id;
	private AuthType authType;

	//Convenient methods for functional programming, especially at Predicate
	public boolean isViewer() {
		return authType == VIEWER;
	}
	public boolean isWriter() {
		return authType == WRITER;
	}
	public boolean isAdmin() {
		return authType == ADMIN;
	}
}
