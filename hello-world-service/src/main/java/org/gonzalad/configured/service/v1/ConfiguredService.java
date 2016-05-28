package org.gonzalad.configured.service.v1;

import org.gonzalad.helloworld.service.v1.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configured/v1")
public class ConfiguredService {
	
	@Value("${info.foo}")
	private String name = "World";

    @Value("${message.greeting}")
    String greeting;

    @Value("${server.port}")
    int port;

    @Value("${spring.application.name}")
    String applicationName;
    
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Response<String> helloconfig() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Hello " + name + " !!!\n")
		.append("message.greeting:").append(greeting).append("\n")
		.append("server.port: ").append(port);
		
		return new Response<String>(sb.toString());
	}
}
