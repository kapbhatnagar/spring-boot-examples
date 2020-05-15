package com.boot.client;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.boot.model.Address;
import com.boot.vo.EmployeeVO;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Component
public class AddressWebClient {

	private static final Logger logger = LoggerFactory.getLogger(AddressWebClient.class);

	public List<Address> getAllAddress() {
		WebClient client = createWebClient();
		List<Address> addressList = client.get().uri("/api/address")
				.accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).exchange().block()
				.bodyToMono(new ParameterizedTypeReference<List<Address>>() {
				}).log().block();
		logger.info("******** Response is:" + addressList.toString());
		return addressList;
	}

	/*
	 * Oftentimes, the default HTTP timeouts of 30 seconds are too slow for our
	 * needs.we can set the connection timeout via the
	 * ChannelOption.CONNECT_TIMEOUT_MILLIS value.
	 * 
	 * sending the request and receiving a response. This can be done with
	 * either the exchange or the retrieve methods.
	 * 
	 * Pay attention to the bodyToMono method, which will throw a
	 * WebClientException if the status code is 4xx (client error) or 5xx
	 * (Server error). We used the block method on Monos to subscribe and
	 * retrieve an actual data which was sent with the response.
	 */
	public Address getAddressWithUodatedTimeout(String id) {
		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.doOnConnected(connection -> {
					connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
					connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
				});
		WebClient client = WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
				.baseUrl("http://localhost:8080").build();
		
		Address address = client.get().uri("/api/address/"+id).accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).retrieve()
				.bodyToMono(Address.class).block();
		return address;
	}

	public Address getAddress(String id) {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();

		client.post().uri("/api/address").accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).exchange().block()
				.bodyToMono(String.class).block();
		return null;
	}

	public Address saveAddress(EmployeeVO employeeVO) {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();
		client.post().uri("/api/address").accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).exchange().block()
				.bodyToMono(String.class).block();
		return null;
	}

	public void callService() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();
		String res = client.get().uri("/api/tutorials").accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
				.exchange().block().bodyToMono(String.class).block();
		System.out.println(res);

	}
	
	private WebClient createWebClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8080")
            /*.defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))*/
            .build();
    }

}
