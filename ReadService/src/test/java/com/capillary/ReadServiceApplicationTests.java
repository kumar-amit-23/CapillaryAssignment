package com.capillary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class ReadServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	private static final String BASE_URL = "http://localhost:9080/to-read";

	@Test
	void testReadController() {
		this.webTestClient.get().uri(BASE_URL).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.exchange().expectStatus().isOk();
	}

}
