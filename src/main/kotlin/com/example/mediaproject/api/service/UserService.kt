package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PostUserRequest
import com.example.mediaproject.api.response.UserResponse
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun registerUser(postUserRequest: PostUserRequest): UserResponse
    fun loginUser(userId: String, password: String): UserResponse

}
