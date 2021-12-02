package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Comment
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val content: String,
    val userId: Long,
    val userName: String,
    val boardId: Long,
    val boardContent: String
)
fun commentResponseOf(comment: Comment): CommentResponse{
    return CommentResponse(
        comment.id,
        comment.createdAt,
        comment.content,
        comment.user.id,
        comment.user.name,
        comment.board.id,
        comment.board.content
    )
}
