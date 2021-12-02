package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.enumerable.UserRole

data class UserAndBoardResponse(
    val id: Long,
    val name: String,
    val email: String?,
    val phoneNumber: String,
    val userRole: UserRole,
    val boardListResponse: List<BoardResponse> = mutableListOf()
)

fun ofUserAndBoardResponse(user: User, boardList: List<BoardResponse>): UserAndBoardResponse {
    return UserAndBoardResponse(
        user.id,
        user.name,
        user.email,
        user.phoneNumber,
        user.userRole,
        boardList
    )

}
