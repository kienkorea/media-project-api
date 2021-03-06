package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.ChangePasswordRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.CommentResponse
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

    @ApiOperation("자기 정보 조회 getMe")
    @GetMapping("/me")
    fun getMe(
        @RequestAttribute userId: Long
    ): ResponseEntity<UserResponse> {
        val response = userService.getMe(userId)
        return ResponseEntity.ok(response)
    }

    @ApiOperation("내가 쓴 보드 리스트 조회 (My page)")
    @GetMapping("/my-boards")
    fun getAllMyBoard(
        @RequestAttribute userId: Long
    ): ResponseEntity<List<BoardDetailResponse>> {
        val response = userService.getAllMyBoard(userId)
        return ResponseEntity.ok(response)
    }

    @ApiOperation("내가 쓴 댓글 리스트 조회 (My page)")
    @GetMapping("/my-comments")
    fun getAllMyComment(
        @RequestAttribute userId: Long
    ): ResponseEntity<List<CommentResponse>> {
        val response = userService.getAllMyComment(userId)
        return ResponseEntity.ok(response)
    }

    @Deprecated("지금 사용하지 않음")
    @ApiOperation("유저가 좋아요 누른 보드 리스트 조회 (My page)")
    @GetMapping("/my-likes")
    fun getMyLikeBoardList(
        @RequestAttribute userId: Long
    ): ResponseEntity<UserAndBoardResponse> {
        val response = userService.getMyLikeBoardList(userId)
        return ResponseEntity.ok(response)
    }

    @Deprecated("지금 사용하지 않음")
    @ApiOperation("유저 비밀번호 재설정")
    @PostMapping("/reset-password")
    fun resetPassword(
        @RequestAttribute userId: Long,
        @RequestParam needChangePassword: Boolean
    ): ResponseEntity<UserResponse> {
        val response: UserResponse = userService.resetPassword(userId, needChangePassword)
        return  ResponseEntity.ok(response)
    }
    @Deprecated("지금 사용하지 않음")
    @ApiOperation("유저 비밀번호 변경")
    @PostMapping("/change-password")
    fun changePassword(
        @RequestAttribute userId: Long,
        @RequestBody changePasswordRequest: ChangePasswordRequest
    ): ResponseEntity<UserResponse> {
        val response: UserResponse = userService.changePassword(userId, changePasswordRequest)
        return  ResponseEntity.ok(response)
    }


    @Deprecated("지금 사용하지 않음")
    @ApiOperation("모든 유저 조회 API")
    @GetMapping("/list")
    fun getAllUser(
        @RequestParam("q", required = false) q: String?
    ): ResponseEntity<List<UserResponse>> {
        val response = userService.getAllUser(q)
        return  ResponseEntity.ok(response)
    }

}