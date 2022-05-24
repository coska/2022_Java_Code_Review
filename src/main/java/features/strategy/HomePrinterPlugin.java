/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.strategy;

import features.factory.PrintType;
import org.springframework.stereotype.Component;

@Component
public class HomePrinterPlugin implements PrinterPlugin {

	@Override
	public String print() {
		return "Home";
	}

	@Override
	public boolean supports(PrintType printType) {
		return printType == PrintType.HOME;
	}
}
