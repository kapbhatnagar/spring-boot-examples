package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HospitalDemoConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(HospitalDemoConfigServerApp.class, args);
	}

}
