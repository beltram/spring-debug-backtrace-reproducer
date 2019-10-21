package com.spring.reproducer.spring.debug.backtrace.reproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.spring.reproducer"])
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}