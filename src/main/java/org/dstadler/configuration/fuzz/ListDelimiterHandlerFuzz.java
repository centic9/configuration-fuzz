package org.dstadler.configuration.fuzz;

import java.nio.charset.StandardCharsets;

import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.convert.LegacyListDelimiterHandler;
import org.apache.commons.configuration2.convert.ListDelimiterHandler;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

/**
 * This class provides a simple target for fuzzing Apache Commons Configuration with Jazzer.
 *
 * It uses the fuzzed input data to try to detect and unpack archives.
 *
 * It catches all exceptions that are currently expected.
 */
public class ListDelimiterHandlerFuzz {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		final char delimiter = data.consumeChar();
		final ListDelimiterHandler handler;
		final int type = data.consumeInt(0, 2);
		switch (type) {
			case 0:
				handler = new DefaultListDelimiterHandler(delimiter);
				break;
			case 1:
				handler = new DisabledListDelimiterHandler();
				break;
			case 2:
				handler = new LegacyListDelimiterHandler(delimiter);
				break;
			default:
				throw new IllegalStateException("Unexpected case: " +  type);
		}

		if (data.consumeBoolean()) {
			handler.parse(data);
		} else {
			handler.parse(new String(data.consumeRemainingAsBytes(), StandardCharsets.UTF_8));
		}
	}
}
