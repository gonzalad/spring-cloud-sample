package org.gonzalad.caller.service.v1;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client du service LoggerService (du projet common-service).
 */
@FeignClient("common-service")
public interface LoggerServiceClient {

	@RequestMapping(method = RequestMethod.POST, value = "/logger/v1/info", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void info(@RequestBody Message message);

	public static class Message {
		private String message;
		
		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}