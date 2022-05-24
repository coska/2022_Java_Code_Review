/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex11.optional.functional;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public class ExceptionAnalyzerMapOrElse {

	public boolean isRetryable(Throwable throwable) {
		return getHttpStatus(throwable)
				.map(ExceptionAnalyzerMapOrElse::isRetryable)
				.orElse(false);
	}

	private static boolean isRetryable(HttpStatus statusCode) {
		return statusCode.is5xxServerError()
				&& statusCode == HttpStatus.PROXY_AUTHENTICATION_REQUIRED;
	}

	Optional<HttpStatus> getHttpStatus(Throwable throwable) {
		//Assume it reads the throwable and returns a proper HttpStatus if feasible.
		return Optional.empty();    //when it cannot derive of...
	}
}
