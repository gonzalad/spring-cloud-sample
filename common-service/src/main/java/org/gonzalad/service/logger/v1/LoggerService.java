package org.gonzalad.service.logger.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger/v1")
public class LoggerService {
	private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);

    @Value("${message.prefix}")
    private String messagePrefix;
    
	@RequestMapping(value = "info", produces = "application/json", method = RequestMethod.POST)
	public void info(@RequestBody Message message) {
		logger.info(messagePrefix + " " + message.getMessage());
	}
}
