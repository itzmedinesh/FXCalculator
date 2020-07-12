package io.fx.calculator.rates;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyConversionRatesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLookup() {
		Assert.assertNotNull(CurrencyConversionRates.lookup("AUD", "USD"));
		Assert.assertEquals("0.8371", CurrencyConversionRates.lookup("AUD", "USD").toString());

		Assert.assertNull(CurrencyConversionRates.lookup("MAE", "USD"));

		Assert.assertNull(CurrencyConversionRates.lookup(null, "USD"));

		Assert.assertNull(CurrencyConversionRates.lookup("MAE", null));

	}

}
