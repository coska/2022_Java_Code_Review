/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package features.strategy;

import lombok.RequiredArgsConstructor;
import features.factory.PrintType;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrintOut {

	private final PluginRegistry<PrinterPlugin, PrintType> printerPlugins;

	public void print(PrintType printType) {
		printerPlugins.getPluginFor(printType)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Print type [%s] is not implemented under PrinterPlugin.", printType)))
				.print();
	}
}
