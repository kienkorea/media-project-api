package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.TokenResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface TokenService {
    fun refreshTokenByPhoneNumber(httpResponse: HttpServletResponse, userId: Long): TokenResponse
    fun refreshToken(request: HttpServletRequest, response: HttpServletResponse, refreshTokenString: String): TokenResponse
}
