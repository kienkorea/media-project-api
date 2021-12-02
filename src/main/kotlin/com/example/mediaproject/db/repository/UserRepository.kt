package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByPhoneNumber(phoneNumber: String): User?
    fun findAllByPhoneNumber(phoneNumber: String): MutableList<User>
}
