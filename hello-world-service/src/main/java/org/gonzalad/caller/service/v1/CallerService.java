package org.gonzalad.caller.service.v1;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caller/v1")
public class CallerService {
	
	@Inject
	private LoggerServiceClient loggerServiceClient;
	
	@RequestMapping(method = RequestMethod.POST, value = "/info")
	public void info(@RequestBody LogMessage logMessage) {
		loggerServiceClient.info(new LoggerServiceClient.Message(logMessage.getClassName() + ": " + logMessage.getMessage()));
	}
}