package com.spring.reproducer.spring.debug.backtrace.reproducer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping("/api/errors")
class ErrorController {
	
	@GetMapping
	fun someErrors(): Mono<*> {
		val errorA = IllegalStateException("Error A").toMono<Any>()
		val errorB = IllegalStateException("Error B").toMono<Any>()
		return Mono.zipDelayError(errorA, errorB)
	}
}