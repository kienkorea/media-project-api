package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.ChangePasswordRequest
import com.example.mediaproject.api.response.AccountResponse
import com.example.mediaproject.api.response.UserAndBoardResponse
import com.example.mediaproject.api.response.UserResponse
import com.example.mediaproject.api.service.UserService
import io.swagger.annotations.ApiOperation
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

    @ApiOperation("유저 비밀번호 재설정")
    @PostMapping("/reset-password")
    fun resetPassword(
        @RequestAttribute userId: Long,
        @RequestParam needChangePassword: Boolean
    ): ResponseEntity<UserResponse> {
        val response: UserResponse = userService.resetPassword(userId, needChangePassword)
        return  ResponseEntity.ok(response)
    }

    @ApiOperation("유저 비밀번호 변경")
    @PostMapping("/change-password")
    fun changePassword(
        @RequestAttribute userId: Long,
        @RequestBody changePasswordRequest: ChangePasswordRequest
    ): ResponseEntity<UserResponse> {
        val response: UserResponse = userService.changePassword(userId, changePasswordRequest)
        return  ResponseEntity.ok(response)
    }

}