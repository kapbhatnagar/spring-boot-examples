package com.boot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String renderPage(Map<String, Object> model){
		System.out.println("Rendering page.");
		return "welcome";
	}

}
