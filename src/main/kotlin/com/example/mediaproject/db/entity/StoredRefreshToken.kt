package com.example.mediaproject.db.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class StoredRefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0
    val createdAt : LocalDateTime = LocalDateTime.now()
    var updatedAt : LocalDateTime? = null

    lateinit var refreshToken: String
    lateinit var refreshExpiresAt: LocalDateTime
    var userId: Long = -1
}