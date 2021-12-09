package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.BoardLike

data class BoardLikeResponse(
    val id: Long,
    val userId: Long,
    val boardId: Long,
    val isLiked: Boolean
)
fun boardLikeResponseOf(boardLike: BoardLike): BoardLikeResponse{
    return BoardLikeResponse(
        boardLike.id,
        boardLike.user.id,
        boardLike.board.id,
        boardLike.isLiked
    )
}
