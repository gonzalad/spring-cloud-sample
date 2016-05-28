# How to run

 * Start discovery-server (Eureka)
 * Start the config-server
 * Start the common-service
 * Run the hello-world-service
   You can run it from :
   * Eclipse (right click org.gonzalad.Application)
   * Gradle command line (./gradlew bootRun)
   * Gradle command line (./gradlew build && java -jar build/libs/hello-world-service-0.1.0-SNAPSHOT.jar
 * Test the service
   HTTP POST to http://localhost:8080/caller/v1/info, Content Type: application/json, message body:
	{
	  "message": "MySource"
	  "className": "hello"
	}
	You'll see a log message in sysout.
	

