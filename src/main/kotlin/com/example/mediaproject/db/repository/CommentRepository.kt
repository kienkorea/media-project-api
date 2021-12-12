package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {
    fun findAllByUserId(userId: Long): List<Comment>
}
