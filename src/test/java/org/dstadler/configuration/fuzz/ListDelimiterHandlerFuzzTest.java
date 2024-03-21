package org.dstadler.configuration.fuzz;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

class ListDelimiterHandlerFuzzTest {
	private final FuzzedDataProvider provider = mock(FuzzedDataProvider.class);

	@Test
	public void testEmpty() {
		when(provider.consumeChar()).thenReturn(',');
		when(provider.consumeInt(anyInt(), anyInt())).thenReturn(0);
		when(provider.consumeBoolean()).thenReturn(false);
		when(provider.consumeRemainingAsBytes()).thenReturn(new byte[0]);

		ListDelimiterHandlerFuzz.fuzzerTestOneInput(provider);
	}

	@Test
	public void testSomeBytes() {
		when(provider.consumeChar()).thenReturn(',');
		when(provider.consumeInt(anyInt(), anyInt())).thenReturn(0);
		when(provider.consumeBoolean()).thenReturn(false);
		when(provider.consumeRemainingAsBytes()).thenReturn(new byte[] { 1, 2, 3});

		ListDelimiterHandlerFuzz.fuzzerTestOneInput(provider);
	}
}