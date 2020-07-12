package io.fx.calculator.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InlineInputParser implements InputParser {
	private static final Logger log = LoggerFactory.getLogger(InlineInputParser.class);

	@Override
	public Input parse(String[] command) {
		if (!isValid(command)) {
			log.error("Invalid command input. USAGE [\"<ccy1> <amount1> in <ccy2>\"]");
			return null;
		}
		return new Input(command[0], command[3], Double.parseDouble(command[1]));
	}

	private boolean isValid(String[] command) {
		if (command == null || command.length != 4)
			return false;

		if (command[0].length() != 3 || command[3].length() != 3 || !"in".equals(command[2]))
			return false;

		try {
			Double.parseDouble(command[1]);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
