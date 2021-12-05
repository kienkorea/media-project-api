package com.example.mediaproject.api.response

import com.example.mediaproject.common.utils.maskPhoneNumber
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.enumerable.UserRole

class UserResponse(
    val id: Long,
    val name: String,
    val email: String?,
    val phoneNumber: String,
    val userRole: UserRole,
    val needChangePassword: Boolean
)
fun userResponseOf(user: User): UserResponse{
    return UserResponse(
        user.id,
        user.name,
        user.email,
        maskPhoneNumber(user.phoneNumber),
        user.userRole,
        user.needChangePassword
    )
}