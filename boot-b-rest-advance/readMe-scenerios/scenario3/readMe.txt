# This scenario covers spring client to consume rest services
# RestTemplate -> As of Spring Framework 5, alongside the WebFlux stack, 
	Spring introduced a new HTTP client called WebClient. 
	The WebClient is a modern, alternative HTTP client to RestTemplate.
# WebClient is an interface representing the main entry point for performing web requests.
# The new WebClient is a reactive, non-blocking solution that works over the HTTP/1.1 protocol.
# Maven dependencies
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-webflux</artifactId>
	</dependency>
	<dependency>
	    <groupId>org.projectreactor</groupId>
	    <artifactId>reactor-spring</artifactId>
	    <version>1.0.1.RELEASE</version>
	</dependency>
#The retrieve() method is the simplest way to get the response body. 
	However, If you want to have more control over the response, 
	then you can use the exchange() method