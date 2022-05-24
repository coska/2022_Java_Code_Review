/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.strategy;

import features.factory.PrintType;
import org.springframework.plugin.core.Plugin;

public interface PrinterPlugin extends Plugin<PrintType> {

	String print();
}
