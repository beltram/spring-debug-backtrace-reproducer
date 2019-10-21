package com.spring.reproducer.spring.debug.backtrace.reproducer

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.Exceptions

@RestControllerAdvice("com.spring.reproducer")
class ErrorAdvice {
	
	@ExceptionHandler(Exception::class)
	fun handle(exception: Exception): ResponseEntity<Int> {
		return Exceptions.unwrapMultiple(exception).size.let { ResponseEntity(it, INTERNAL_SERVER_ERROR) }
	}
}