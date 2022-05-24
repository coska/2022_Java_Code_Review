/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.factory.before.printer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import features.factory.PrintType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Printers {

	public static Printer of(PrintType type) {
		if (type == PrintType.HOME) {
			return new HomePrinter();
		}
		return new WorkplacePrinter();
	}
}