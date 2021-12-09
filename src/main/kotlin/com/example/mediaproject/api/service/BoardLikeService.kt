package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.BoardLikeResponse
import org.springframework.stereotype.Service

@Service
interface BoardLikeService {
    fun postLike(boardId: Long, userId: Long): BoardLikeResponse
    fun deleteLike(boardLikeId: Long): Boolean

}
