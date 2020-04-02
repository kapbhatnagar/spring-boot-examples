package com.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		
		//Some java 8 prog
		List<String> list = new ArrayList<>();
		list.add("hey");
		list.add("hello");
		
		list.forEach(res -> System.err.println(list));
		list.forEach(System.out::println);
		
		return "welcome";
	}

}