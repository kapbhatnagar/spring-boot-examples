package com.boot.scenario3.rest.client;

import org.springframework.web.client.RestTemplate;

/**
 * Simple main method class to consume rest service. 
 * RestTemplate have diff methods like getForObject, getForEntity, postForObject
 * */
public class RestTemplateEg {

	public static void main(String[] args) {
		String uri = "http://localhost:8080/api/tutorials/4";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.err.println(result);
	    
	}

}
