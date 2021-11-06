package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PostUserRequest
import com.example.mediaproject.api.response.UserResponse
import com.example.mediaproject.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/media-project/up-down/users")
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun registerUser(
        @RequestBody postUserRequest: PostUserRequest
    ): ResponseEntity<UserResponse> {
        val response = userService.registerUser(postUserRequest)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun loginUser(
        @RequestParam userId: String,
        @RequestParam password: String
    ): ResponseEntity<UserResponse>{
        val checkExistUserId: UserResponse = userService.loginUser(userId, password)
        return  ResponseEntity.ok(checkExistUserId)
    }


}