/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.factory.interfaceof;

import features.factory.PrintType;
import features.factory.interfaceof.printer.Printer;

public class PrintOut {

	public static void main(String[] args) {
		final Printer printer = Printer.of(PrintType.WORK);
		System.out.println(printer.print());
	}
}
