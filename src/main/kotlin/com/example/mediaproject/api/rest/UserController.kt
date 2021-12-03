package com.example.mediaproject.api.rest

import com.example.mediaproject.api.response.UserAndBoardResponse
import com.example.mediaproject.api.response.UserResponse
import com.example.mediaproject.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/media-project/up-down/users")
@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/me")
    fun getMe(
        @RequestAttribute userId: Long
    ): ResponseEntity<UserResponse> {
        val response = userService.getMe(userId)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/my-board")
    fun getAllMyBoard(
        @RequestAttribute userId: Long
    ): ResponseEntity<UserAndBoardResponse> {
        val response = userService.getAllMyBoard(userId)
        return ResponseEntity.ok(response)
    }

}