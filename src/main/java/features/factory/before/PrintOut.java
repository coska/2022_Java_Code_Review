/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.factory.before;

import features.factory.PrintType;
import features.factory.before.printer.Printer;
import features.factory.before.printer.Printers;

public class PrintOut {

	public static void main(String[] args) {
		final Printer printer = Printers.of(PrintType.WORK);
		System.out.println(printer.print());
	}
}
