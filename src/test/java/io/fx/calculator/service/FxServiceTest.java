package io.fx.calculator.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FxServiceTest {

	private static final Logger log = LoggerFactory.getLogger(FxServiceTest.class);

	FxService fxService;

	@Before
	public void setUp() throws Exception {
		fxService = new FxService();
	}

	@Test
	public void testExecute() {
		String[] command = new String[] { "AUD", "100", "in", "USD" };
		String output = fxService.execute(command);
		Assert.assertNotNull(output);
		log.info("{} {} = {} {}", command[1], command[0], output, command[3]);

		command = new String[] { "USD", "100", "in", "AUD" };
		output = fxService.execute(command);
		Assert.assertNotNull(output);
		log.info("{} {} = {} {}", command[1], command[0], output, command[3]);

		command = new String[] { "USD", "100", "in", "NOK" };
		output = fxService.execute(command);
		Assert.assertNotNull(output);
		log.info("{} {} = {} {}", command[1], command[0], output, command[3]);

	}

}
