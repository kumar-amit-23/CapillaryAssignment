package com.capillary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class BookStoreController {

	@GetMapping(value = "/recommended")
	public Mono<String> readingList() {
		return Mono.just("Service is Up.");
	}

}
