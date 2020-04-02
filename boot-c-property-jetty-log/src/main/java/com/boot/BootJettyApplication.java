package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJettyApplication.class, args);
	}
	
	//Set VM argument -Dspring.profiles.active=UAT

}
