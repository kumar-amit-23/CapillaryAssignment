package com.capillary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capillary.service.BookReadService;

@RestController
public class ReadController {
	@Autowired
	private BookReadService bookReadService;

	@GetMapping("/to-read")
	public ResponseEntity<String> toRead() {
		return bookReadService.readBook();
	}
}
