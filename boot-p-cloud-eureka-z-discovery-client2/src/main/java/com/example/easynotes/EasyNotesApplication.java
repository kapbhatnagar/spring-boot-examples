package com.example.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EasyNotesApplication {
// Link https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
// @EnableJpaAuditing and @EntityListeners to set date automatically
	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
	}
}
