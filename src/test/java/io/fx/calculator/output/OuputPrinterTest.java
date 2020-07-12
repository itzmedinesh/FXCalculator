package io.fx.calculator.output;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.fx.calculator.input.Input;

public class OuputPrinterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvertAndPrint() {
		Input input = new Input("AUD", "USD", 100.00);

		String convertedFormattedAmount = OutputPrinter.convertAndPrint(input, 0.8371);

		Assert.assertEquals("83.71", convertedFormattedAmount);

		input = new Input("USD", "JPY", 1000.00);

		convertedFormattedAmount = OutputPrinter.convertAndPrint(input, 119.95);

		Assert.assertEquals("119950", convertedFormattedAmount);
	}

}
