# How to run

 * Start discovery-server (Eureka)
 * Run the config-server
 * Run the common-service
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/common-service-0.1.0-SNAPSHOT.jar
 * Test the service
   HTTP POST to http://localhost:8081/logger/v1/info, Content Type: application/json, message body:
	{
	  "message": "hello"
	}
	You'll see a log message in sysout.
	

# Common Services

Sample Spring REST Service.


## Logging Service

The logging service accepts a message as parameter and logs (info LEVEL) the message.

# Spring Cloud Config Demo

This project uses spring-cloud-config-client.
Config server url is located inside bootstrap.yml.  
The config is located in /home/ubuntu/config-repo GIT repo. This config is served by Config Server.

On startup, Common Services looks up Config Server and loads common-service.yml, application.yml located in the GIT repository.

This enables us to store the following information inside GIT config repository :
 * Common Services HTTP listen port (8081)
 * Common Services logging levels.
 * Application configuration (see LoggingService implementation).
 
To refresh the configuration (including logging levels), just execute a POST /refresh (http://localhost:8081/refresh).


# Gotchas

 * Cannot override server.port with a system property when server.port is defined in Config Server.
   workaround : include a system property inside Config Server's configuration, 
   i.e. in ~/config-repo/common-service.yml :
	server:
	  port: ${port:8081}
   And just start the Common Services with -Dport=8082 or any other port you like.
 
   
# TODOs 

 * Test git repository modification push
 * Test Spring Cloud notification for client apps