package com.example.mediaproject.common.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.mediaproject.common.model.ISSUER
import com.example.mediaproject.common.model.SECRET
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class TokenUtils {
}

fun getToken(phoneNumber: String, expires: Instant, userId: Long): String {
    return JWT.create()
        .withSubject(phoneNumber)
        .withExpiresAt(Date.from(expires))
        .withIssuer(ISSUER)
        .withClaim("userId", userId)
        .withIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
        .sign(Algorithm.HMAC512(SECRET.toByteArray()))
}
