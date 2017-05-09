package com.an3ll.kotlin.reactive

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RestDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(RestDemoApplication::class.java, *args)
}
