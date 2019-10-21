package com.spring.reproducer.spring.debug.backtrace.reproducer

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@SpringBootTest
@AutoConfigureWebTestClient
class ErrorControllerTest(@Autowired private val webTestClient: WebTestClient) {
	
	@Test
	fun `should only get errors A & B`() {
		webTestClient.get()
				.uri("/api/errors")
				.exchange()
				.expectStatus().is5xxServerError
				.expectBody<Int>()
				.returnResult().apply { assertThat(responseBody!!).isEqualTo(2) }
	}
}