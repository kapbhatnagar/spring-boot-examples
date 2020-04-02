package com.boot.scenario3.rest.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientEg {

	private void callService() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();
		String res = client.get().uri("/api/tutorials").accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
				.exchange().block().bodyToMono(String.class).block();
		System.out.println(res);

	}

	public static void main(String[] args) {
		System.out.println("==========Start=========");
		WebClientEg clientEg = new WebClientEg();
		clientEg.callService();
		System.out.println("==========End=========");
	}

}
