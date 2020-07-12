package io.fx.calculator.input;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.fx.calculator.input.InlineInputParser;
import io.fx.calculator.input.Input;
import io.fx.calculator.input.InputParser;

public class InlineInputParserTest {

	InputParser inputParser;

	@Before
	public void setUp() throws Exception {
		inputParser = new InlineInputParser();
	}

	@Test
	public void testParse() {
		Input input = inputParser.parse(new String[] { "kdjfk djfkd" });
		Assert.assertNull(input);

		input = inputParser.parse(new String[] { "USD", "100.00", "in", "AUD" });
		Assert.assertNotNull(input);
		Assert.assertTrue(input.getFromCurrency().equals("USD"));
		Assert.assertTrue(input.getToCurrency().equals("AUD"));
		Assert.assertTrue(input.getFromCurrencyAmount() == 100.00);
	}

}
