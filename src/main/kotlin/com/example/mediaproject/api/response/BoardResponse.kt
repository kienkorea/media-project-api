package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Board
import java.time.LocalDateTime

data class BoardResponse(
    val id: Long,

    val createBy: Long,
    val authorName: String,

    val createAt: LocalDateTime? = null,
    val title: String,
    val content: String

)
fun boardResponseOf(board: Board): BoardResponse{
    return BoardResponse(
        board.id,
        board.user.id,
        board.user.name,
        board.createdAt,
        board.title,
        board.content
    )
}
