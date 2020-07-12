package io.fx.calculator.rates;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyConversionRates {

	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionRates.class);

	private static Map<String, Double> currencyConversionRates = new HashMap<>();

	private static Map<String, String> currencyConversionRules = new HashMap<>();

	static {
		currencyConversionRates.put("AUDUSD", 0.695);
		currencyConversionRates.put("CADUSD", 0.8711);
		currencyConversionRates.put("USDCNY", 6.1715);
		currencyConversionRates.put("EURUSD", 1.1315);
		currencyConversionRates.put("USDEUR", 0.8950);
		currencyConversionRates.put("GBPUSD", 1.5683);
		currencyConversionRates.put("NZDUSD", 0.7750);
		currencyConversionRates.put("USDJPY", 119.95);
		currencyConversionRates.put("EURCZK", 27.6028);
		currencyConversionRates.put("EURDKK", 7.4405);
		currencyConversionRates.put("EURNOK", 10.65);

		currencyConversionRules.put("AUDAUD", "1:1");
		currencyConversionRules.put("AUDUSD", "DIR");
		currencyConversionRules.put("USDAUD", "INV");
		currencyConversionRules.put("USDNOK", "EUR");
		currencyConversionRules.put("USDEUR", "INV");
		currencyConversionRules.put("EURNOK", "DIR");

	}

	public static Double lookup(String fromCurrency, String toCurrency) {
		if (fromCurrency == null || toCurrency == null) {
			log.error("Invalid input currency");
			return null;
		}

		return currencyConversionRates.get(fromCurrency.toUpperCase() + toCurrency.toUpperCase());
	}

	public static String lookupRules(String fromCurrency, String toCurrency) {

		if (fromCurrency == null || toCurrency == null) {
			log.error("Invalid input currency");
			return null;
		}
		return currencyConversionRules.get(fromCurrency.toUpperCase() + toCurrency.toUpperCase());
	}

}
