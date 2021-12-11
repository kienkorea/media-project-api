package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Board
import java.time.LocalDateTime
import kotlin.streams.toList

data class BoardDetailResponse(
    val id: Long,
    val createBy: Long,
    val authorName: String,

    val createAt: LocalDateTime? = null,
    val content: String,
    val totalLike: Long,
    val totalComment: Long,

    val commentListResponse: List<CommentResponse> = mutableListOf(),
    val isMyBoard: Boolean = false
)

fun boardDetailResponseOf(board: Board): BoardDetailResponse {
    return BoardDetailResponse(
        board.id,
        board.user.id,
        board.user.name,
        board.createdAt,
        board.content,
        board.likeList.size.toLong(),
        board.commentList.size.toLong(),
        board.commentList.stream().map { commentResponseOf(it) }.toList()
    )
}

fun boardDetailResponseOf(board: Board, userId: Long): BoardDetailResponse {
    var isMyBoard = false
    if(board.user.id == userId) isMyBoard = true
    return BoardDetailResponse(
        board.id,
        board.user.id,
        board.user.name,
        board.createdAt,
        board.content,
        board.likeList.size.toLong(),
        board.commentList.size.toLong(),
        board.commentList.stream().map { commentResponseOf(it, userId) }.toList(),
        isMyBoard
    )
}