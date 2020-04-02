package com.boot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecuterEg {

	@Value("${spring.application.name}")
	private String applicationName;
	
	private static final Logger logger = LoggerFactory.getLogger(ExecuterEg.class);

	@RequestMapping(path = "/multithread")
	public String executerMethod() {
		logger.info("Calling multithreading example for application= " + applicationName);
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		executorService.execute(() -> print("processOne"));
		executorService.execute(() -> print("processTwo"));
		executorService.execute(() -> print("processThree"));
		executorService.execute(() -> print("processFour"));
		executorService.execute(() -> print("processFive"));
		return "Done..";
	}

	private void print(String processName) {
		logger.debug("Start " + processName + ". and calling from thread:" + Thread.currentThread().getName());
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("Completed " + processName + " from thread:" + Thread.currentThread().getName());
	}

}
