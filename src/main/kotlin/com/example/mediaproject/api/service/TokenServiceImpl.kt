package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.TokenResponse
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.common.model.HEADER_STRING
import com.example.mediaproject.common.model.TOKEN_PREFIX
import com.example.mediaproject.common.utils.getToken
import com.example.mediaproject.db.entity.StoredRefreshToken
import com.example.mediaproject.db.repository.StoredRefreshTokenRepository
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.nimbusds.oauth2.sdk.token.RefreshToken

@Service
class TokenServiceImpl(
    private val userRepository: UserRepository,
    private val storedRefreshTokenRepository: StoredRefreshTokenRepository
) : TokenService {

    override fun refreshTokenByPhoneNumber(httpResponse: HttpServletResponse, userId: Long): TokenResponse {
        val tokenResponse: TokenResponse = userRepository.findById(userId).orElseThrow { BadRequestException("유저를 찾을 수 없습니다. -> $userId") }
            .let {
                val phoneNumber = it.phoneNumber
                val expires = LocalDateTime.now().plusMonths(1).atZone(ZoneId.systemDefault()).toInstant()
                val accessToken = getToken(phoneNumber, expires, userId)
                val refreshToken = StoredRefreshToken().apply{
                    this.refreshToken = RefreshToken().value
                    this.refreshExpiresAt = LocalDateTime.now().plusMonths(6)
                    this.userId = userId
                }
                storedRefreshTokenRepository.save(refreshToken)
                TokenResponse(
                    accessToken = accessToken,
                    refreshToken = refreshToken.refreshToken,
                    refreshExpiresAt = refreshToken.refreshExpiresAt,
                    expires = expires.toEpochMilli()
                )
            }

        return tokenResponse.also {
            httpResponse.addHeader(HEADER_STRING, TOKEN_PREFIX + it.accessToken)
        }
    }

    override fun refreshToken(request: HttpServletRequest, response: HttpServletResponse, refreshTokenString: String): TokenResponse {
        val refreshToken: StoredRefreshToken = storedRefreshTokenRepository.findByRefreshToken(refreshTokenString).orElseThrow { throw BadRequestException("리프레시 토큰이 없습니다.") }
        if (refreshToken.refreshExpiresAt.isBefore(LocalDateTime.now())) throw BadRequestException("리프레시 유효기간이 경과했습니다.")
        storedRefreshTokenRepository.delete(refreshToken)
        return refreshTokenByPhoneNumber(response, refreshToken.userId)
    }

}
