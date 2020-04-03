package com.hospital.hospitaldemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HospitalController {
	
	@Value("${greeting}")
	String greetingVal;
	
	@RequestMapping(path="/welcome")
	public String displayWelomeMsg(){
		System.out.println("hey----- "+ greetingVal);
		return "welcome";
	}

}
