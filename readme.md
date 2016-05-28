# Spring Cloud Sample

This sample projects demonstrates Spring Cloud usage (one more time !) :

 * Spring Cloud Config Server 
   [project : discovery-server]
   For port configuration and application configuration.
 * Spring Cloud Discovery Server (Eureka implementation)
   [project : config-server]
   Service registering and discovery
 * Basic Docker image creation (just using a gradle plugin)
 * Hello world Services
   [project : hello-world-service]
   Houses 3 services :
    * HelloWorldService : Basic Hello World Rest Service using configuration from Spring Cloud Config
    * ConfiguredService : Similar with more configuration options
    * CallerService : This one calls another service (in project common-service) by using @FeignClient
      (load balancing, ...) and Spring Cloud Discovery to retrieve the service Url.
      

# How to run

From spring-cloud-sample :

 * Build all server side modules

   ./gradlew build

 * Start discovery-server (Eureka)
   Default port : 
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/discovery-server-0.1.0-SNAPSHOT.jar
 * Run the config-server
   Default port: 8888
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/config-server-0.1.0-SNAPSHOT.jar
 * Run the common-service
   Default port : 8081 (override with -Dport=<port>)
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/common-service-0.1.0-SNAPSHOT.jar
 * Run the hello-world-service
   Default port: 8080 (override with -Dport=<port>)
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/hello-world-service-0.1.0-SNAPSHOT.jar


# 2 words on Spring Cloud Discovery and Config Servers

This project uses spring-cloud-config-client.
Config server url is provided by Spring Cloud Discovery Server (Eureka).  
The config repository is a Git repository located https://github.com/gonzalad/config-repo (master branch).

On startup, each service (more exactly each application) looks for Discovery Server and register itself.

It then asks the Discovery Server the adress of each service they'll use (Common Service uses Config Server, HelloWorld Servuce uses Common Services and Config Server).

If the service need config data from Config Server, it then asks the Config Server about it's configuration (Config Server gets all configuration data from files <application-name>.[yml|properties] and application.[yml|properties] in the Git repository.

To refresh the configuration (including logging levels), just execute a POST /refresh (http://localhost:8081/refresh).


# How to use the applications

## Common Service

 * LoggerService 
   This logger service accepts a message as parameter and logs (info LEVEL) the message.
   HTTP POST to http://localhost:8081/logger/v1/info, Content Type: application/json, message body:
	{
	  "message": "hello"
	}
	You'll see a log message in sysout.


## Hello World Service

 * Caller Service 
   The service will call LoggerService (in Common Service application), and you'll see a log in Common Service sysout.
   HTTP POST to http://localhost:8080/caller/v1/info, Content Type: application/json, message body:
  
       {
             "message": "MySource"
             "className": "hello"
       }

   You'll see a log message in sysout.
 * Hello World Service 
   HTTP GET to http://localhost:8080/v1, Content Type: application/json, it will return a message like

       {
             "data": "Hello World"
       }
 * Configured Service 
   HTTP GET to http://localhost:8080/configured/v1, Content Type: application/json


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
