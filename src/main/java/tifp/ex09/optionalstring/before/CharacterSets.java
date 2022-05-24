/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex09.optionalstring.before;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterSets {

	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public Charset of(String charset) {
		// this kind of condition statement is noisy and not readable.
		if (charset == null || charset.isEmpty() || charset.isBlank()) {
			return DEFAULT_CHARSET;
		}
		return Charset.forName(charset);
	}
}
