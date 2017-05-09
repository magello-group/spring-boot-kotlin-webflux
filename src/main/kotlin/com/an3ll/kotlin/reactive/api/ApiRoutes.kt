package com.an3ll.kotlin.reactive.api

import com.example.demo.restservice.api.handler.UserGetByIdRequestHandler
import com.example.demo.restservice.domain.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRoutes{

  @Bean
  fun apiRouter() = router {

    val userService = UserService()
    val userGetByIdRequestHandler = UserGetByIdRequestHandler(userService)

    (accept(APPLICATION_JSON) and "/rest").nest {

      "/users".nest {
        GET("/{id}", userGetByIdRequestHandler::handleRequest)
      }
    }
  }
}
