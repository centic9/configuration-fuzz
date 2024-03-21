package org.dstadler.configuration.fuzz;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FuzzTest {
	@Test
	public void test() {
		Fuzz.fuzzerTestOneInput(new byte[] {});
		Fuzz.fuzzerTestOneInput(new byte[] {1});
		Fuzz.fuzzerTestOneInput(new byte[] {'P', 'K'});
	}

	@Disabled("Local test for verifying a slow run")
	@Test
	public void testSlowUnit() throws IOException {
		Fuzz.fuzzerTestOneInput(FileUtils.readFileToByteArray(new File("corpus/3035833feec28f5b4bc0ef33c5a7b9b348efe260")));
	}
}