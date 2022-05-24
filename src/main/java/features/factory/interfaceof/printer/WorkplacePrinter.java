/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.factory.interfaceof.printer;

//Notice this is not a public class
class WorkplacePrinter implements Printer {

	@Override
	public String print() {
		return "workplace";
	}
}
