package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.CommentRequest
import com.example.mediaproject.api.response.CommentResponse
import com.example.mediaproject.api.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController(
    private val commentService: CommentService
) {

    @PostMapping
    fun postComment(
        @RequestParam boardId: Long,
        @RequestParam userId: Long,
        @RequestBody commentRequest: CommentRequest
    ): ResponseEntity<CommentResponse>{
        val response = commentService.postComment(boardId, userId, commentRequest)
        return ResponseEntity.ok(response)
    }
}