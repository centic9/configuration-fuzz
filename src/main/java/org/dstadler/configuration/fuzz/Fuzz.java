package org.dstadler.configuration.fuzz;

/**
 * This class provides a simple target for fuzzing Apache Commons Configuration with Jazzer.
 *
 * It uses the fuzzed input data to try to detect and unpack archives.
 *
 * It catches all exceptions that are currently expected.
 */
public class Fuzz {

	public static void fuzzerTestOneInput(byte[] inputData) {
	}
}
