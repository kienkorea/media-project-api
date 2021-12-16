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
    val isMyBoard: Boolean = false,
    val isLiked: Boolean = false,
    val likeId: Long = 0

)

fun boardDetailResponseOf(board: Board, userId: Long): BoardDetailResponse {
    var isMyBoard = false
    var isLiked = false
    var likeId = 0L
    if(board.user.id == userId) isMyBoard = true
    board.likeList.forEach{
        if(it.user.id == userId) {
            likeId = it.id
            isLiked = true
        }
    }
    return BoardDetailResponse(
        board.id,
        board.user.id,
        board.user.name,
        board.createdAt,
        board.content,
        board.likeList.size.toLong(),
        board.commentList.size.toLong(),
        board.commentList.stream().map { commentResponseOf(it, userId) }.toList(),
        isMyBoard,
        isLiked,
        likeId
    )
}