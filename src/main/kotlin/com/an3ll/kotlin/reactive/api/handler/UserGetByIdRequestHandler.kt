package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.UserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse


@Component
open class UserGetByIdRequestHandler(
    private val userService: UserService
) {

  data class Request(
      val id: String
  )

  data class Response(
      val id: String,
      val firstName: String,
      val lastName: String,
      val email: String
  )

  fun handleRequest(request: ServerRequest) =
      ServerResponse.ok()
          .body(fromObject(testUser(request.pathVariable("id"))))

  private fun testUser(id: String): Response {

    val user = userService.getById(id)

    return Response(id = user.id,
        firstName = user.firstName,
        lastName = user.lastName,
        email = user.email
    )
  }
}



