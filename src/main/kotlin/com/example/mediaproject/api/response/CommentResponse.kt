package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Comment
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long,
    val createdAt: LocalDateTime,
//    val content: String,
    val userId: Long,
    val userName: String,
    val boardId: Long,
//    val boardContent: String,
    val isMyComment: Boolean = false
)
fun commentResponseOf(comment: Comment): CommentResponse{
    return CommentResponse(
        comment.id,
        comment.createdAt,
//        comment.content,
        comment.user.id,
        comment.user.name,
        comment.board.id,
//        comment.board.content
    )
}

fun commentResponseOf(comment: Comment, userId: Long): CommentResponse{
    var isMyComment = false
    if(comment.user.id == userId) isMyComment = true
    return CommentResponse(
        comment.id,
        comment.createdAt,
//        comment.content,
        comment.user.id,
        comment.user.name,
        comment.board.id,
//        comment.board.content,
        isMyComment
    )
}
