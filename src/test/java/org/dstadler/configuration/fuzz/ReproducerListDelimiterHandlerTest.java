package org.dstadler.configuration.fuzz;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

public class ReproducerListDelimiterHandlerTest {
	// see how to do this at https://github.com/CodeIntelligenceTesting/jazzer/discussions/600
	@FuzzTest
	public void testSlowAndOOM(FuzzedDataProvider data) {
		Fuzz.fuzzerTestOneInput(data.consumeRemainingAsBytes());
	}
}
