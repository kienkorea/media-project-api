package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Board
import java.time.LocalDateTime

data class BoardResponse(
    val id: Long,

    val createBy: Long,
    val authorName: String,

    val createAt: LocalDateTime? = null,
    val title: String,
    val content: String,
    val totalLike: Long,
    val totalComment: Long,
    val isLiked: Boolean

)
fun boardResponseOf(board: Board): BoardResponse{
    return BoardResponse(
        board.id,
        board.user.id,
        board.user.name,
        board.createdAt,
        board.title,
        board.content,
        board.likeCount,
        board.commentList.size.toLong(),
        board.isLiked
    )
}
