package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository: JpaRepository<Board, Long> {
    fun existsBoardById(boardId: Long): Boolean
    fun findAllByUserId(userId: Long): List<Board>
}
