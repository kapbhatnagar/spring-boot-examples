package com.boot.rest.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.basic.model.Greeting;

@RestController //@RestController = @Controller + @ResponseBody
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Welcome";
	}

	@RequestMapping(value = "/service", produces = "application/json", method = RequestMethod.GET)
	public Map<Integer, String> getServiceResult() {
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "Das Boot");
		myMap.put(2, "Yo yo");
		return myMap;
	}

	@RequestMapping(value = "/servicenew/{id}")
	@ResponseBody
	public Map<Long, String> getNewServiceResult(@PathVariable Long id) {
		Map<Long, String> myMap = new HashMap<>();
		myMap.put(id, "Das Boot.......");
		return myMap;
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(123, String.format("Hello, %s!", name));
	}
}
