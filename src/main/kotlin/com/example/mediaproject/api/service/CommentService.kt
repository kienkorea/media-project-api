package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CommentRequest
import com.example.mediaproject.api.response.CommentResponse
import org.springframework.stereotype.Service

@Service
interface CommentService {
    fun postComment(boardId: Long, userId: Long, commentRequest: CommentRequest): CommentResponse

}
