/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex09.optionalstring.functional;

import static org.apache.commons.lang3.StringUtils.stripToNull;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class CharacterSets2 {

	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public Charset of(String charset) {
		return Optional.ofNullable(stripToNull(charset))
				.map(Charset::forName)
				.orElse(DEFAULT_CHARSET);
	}
}
