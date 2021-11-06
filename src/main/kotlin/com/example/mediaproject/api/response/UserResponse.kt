package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.User

class UserResponse(
    val id: Long,
    val userId: String,
    val password: String,
    val name: String?,
    val email: String?,
    val phoneNumber: String?
)
fun of(user: User): UserResponse{
    return UserResponse(
        user.id,
        user.userId,
        user.password,
        user.name,
        user.email,
        user.phoneNumber
    )
}