package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.UserResponse
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getMe(userId: Long): UserResponse

}
