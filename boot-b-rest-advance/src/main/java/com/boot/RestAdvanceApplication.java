package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.scenario2.data.rest.repo.NoteRepository;

/*@ComponentScan({"com.data","com.data.model","com"}) Note- Facing issue while moving repo class outside main method pkg.
@SpringBootApplication(scanBasePackages = {"com.*"})*/
@SpringBootApplication(scanBasePackages={"com.boot"})
public class RestAdvanceApplication {
	
	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestAdvanceApplication.class, args);
	}

}
