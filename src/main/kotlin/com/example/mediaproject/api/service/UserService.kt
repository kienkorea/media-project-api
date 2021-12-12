package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.ChangePasswordRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.CommentResponse
import com.example.mediaproject.api.response.UserAndBoardResponse
import com.example.mediaproject.api.response.UserResponse
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getMe(userId: Long): UserResponse
    fun getAllMyBoard(userId: Long): List<BoardDetailResponse>
    fun resetPassword(userId: Long, needChangePassword: Boolean): UserResponse
    fun changePassword(userId: Long, changePasswordRequest: ChangePasswordRequest): UserResponse
    fun getMyLikeBoardList(userId: Long): UserAndBoardResponse
    fun getAllUser(q: String?): List<UserResponse>
    fun getAllMyComment(userId: Long): List<CommentResponse>

}
