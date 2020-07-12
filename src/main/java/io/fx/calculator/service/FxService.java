package io.fx.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fx.calculator.input.InlineInputParser;
import io.fx.calculator.input.Input;
import io.fx.calculator.input.InputParser;
import io.fx.calculator.output.OutputPrinter;
import io.fx.calculator.rates.CurrencyConversionRates;

/**
 * FxConverter
 *
 */
public class FxService {

	private static final Logger log = LoggerFactory.getLogger(FxService.class);

	private InputParser inputParser = null;

	public FxService() {
		inputParser = new InlineInputParser();
	}

	public FxService(InputParser inputParser) {
		this.inputParser = inputParser;
	}

	public String execute(String[] command) {

		Input input = inputParser.parse(command);

		Double rate = null;

		if (input != null)
			rate = CurrencyConversionRates.lookup(input.getFromCurrency(), input.getToCurrency());
		else {
			log.error("Invalid command");
			return null;
		}

		if (rate != null) {
			log.info("Conversion Rate from {} to {} : {}", input.getFromCurrency(), input.getToCurrency(), rate);

			String formattedOutput = OutputPrinter.convertAndPrint(input, rate);

			return formattedOutput;
		}

		String rule = CurrencyConversionRates.lookupRules(input.getFromCurrency(), input.getToCurrency());

		if (rule == null) {
			log.error("Could not convert currency for the given input");
			return null;
		}

		String formattedOuput = null;

		switch (rule) {
		case "1:1":
			rate = 1d;
			formattedOuput = OutputPrinter.convertAndPrint(input, rate);
			break;
		case "DIR":
			rate = CurrencyConversionRates.lookup(input.getFromCurrency(), input.getToCurrency());
			formattedOuput = OutputPrinter.convertAndPrint(input, rate);
			break;
		case "INV":
			rate = CurrencyConversionRates.lookup(input.getToCurrency(), input.getFromCurrency());
			input.setFromCurrency(input.getToCurrency());
			input.setToCurrency(input.getFromCurrency());
			formattedOuput = OutputPrinter.convertAndPrint(input, 1 / rate);
			break;
		default:

			String tmprule = CurrencyConversionRates.lookupRules(input.getFromCurrency(), rule);

			if ("INV".equals(tmprule)) {
				String[] tmpcommand = new String[] { input.getFromCurrency(), "" + input.getFromCurrencyAmount(), "in",
						rule };
				String imdtout = execute(tmpcommand);

				tmpcommand = new String[] { rule, imdtout, "in", input.getToCurrency() };
				return execute(tmpcommand);
			}
			double tempval = input.getFromCurrencyAmount() * rate;

			rate = CurrencyConversionRates.lookup(rule, input.getToCurrency());
			input.setFromCurrencyAmount(tempval);
			formattedOuput = OutputPrinter.convertAndPrint(input, rate);
		}
		return formattedOuput;
	}
}
