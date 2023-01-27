package com.capillary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capillary.service.BookReadService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookReadServiceImpl implements BookReadService {

	private static final String CIRCUIT_BREAKER_NAME = "CircuitBreakerReadBook";
	private static final String FALL_BACK_METHOD = "fallBack";
	private static final String BASE_URL = "http://localhost:8080/recommended";
	private static final String SERVICE_DOWN = "Service is Down";

	@Autowired
	private RestTemplate restTemplate;

//	Method to read from BookStoreService Application.
	@Override
	@CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = FALL_BACK_METHOD)
	public ResponseEntity<String> readBook() {

		return this.restTemplate.getForEntity(BASE_URL, String.class);
	}

	public ResponseEntity<String> fallBack(Exception e) {
		return new ResponseEntity<String>(SERVICE_DOWN, HttpStatus.OK);
	}

}
