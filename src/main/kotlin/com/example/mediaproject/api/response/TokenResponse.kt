package com.example.mediaproject.api.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val refreshExpiresAt: LocalDateTime,
    val expires: Long,
    val expiresIn: Long? = 0,
    val tokenType: String?= "bearer"
)