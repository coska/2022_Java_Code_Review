/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.factory.interfaceof.printer;

import features.factory.PrintType;

public interface Printer {

	String print();

	static Printer of(PrintType type) {
		if (type == PrintType.HOME) {
			return new HomePrinter();
		}
		return new WorkplacePrinter();
	}
}
