package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.CommentRequest
import com.example.mediaproject.api.response.CommentResponse
import com.example.mediaproject.api.service.CommentService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/media-project/up-down/comments")
class CommentController(
    private val commentService: CommentService
) {

    @ApiOperation("댓글을 남기기")
    @PostMapping
    fun postComment(
        @RequestAttribute userId: Long,
        @RequestParam boardId: Long,
        @RequestBody commentRequest: CommentRequest
    ): ResponseEntity<CommentResponse>{
        val response = commentService.postComment(boardId, userId, commentRequest)
        return ResponseEntity.ok(response)
    }

    @ApiOperation("댓글을 편집하기")
    @PatchMapping("/{commentId}")
    fun patchComment(
        @RequestAttribute userId: Long,
        @PathVariable commentId: Long,
        @RequestBody commentRequest: CommentRequest
    ): ResponseEntity<CommentResponse>{
        val response: CommentResponse = commentService.patchComment(commentId, userId, commentRequest)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable commentId: Long,
    ): ResponseEntity<Boolean>{
        val response: Boolean = commentService.deleteComment(commentId)
        return ResponseEntity.ok(response)
    }
}