Reproducing [#23827](https://github.com/spring-projects/spring-framework/issues/23827)

## What's inside

Simple controller method throwing a composite exception. In Spring Boot 2.1.X, composite exception contained only expected
exceptions. In Spring Boot 2.2.0, in addition it contains an `reactor.core.publisher.FluxOnAssembly$OnAssemblyException`

## Purpose

Purpose of this is to find a way to remove this extra exception.  
This application contains a single enpoint returning the number of exceptions contained in the composite exception

## How to use

* Run tests `./gradlew test`
* Run `./gradlew bootRun` then `curl http://localhost:8080/api/errors`