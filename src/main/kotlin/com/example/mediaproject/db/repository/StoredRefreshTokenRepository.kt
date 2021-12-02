package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.StoredRefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StoredRefreshTokenRepository: JpaRepository<StoredRefreshToken, Long> {
    fun findByRefreshToken(refreshTokenString: String): Optional<StoredRefreshToken>
    fun findAllByUserId(userId: Long): List<StoredRefreshToken>
}
