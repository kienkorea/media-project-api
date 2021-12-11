package com.example.mediaproject.api.rest

import com.example.mediaproject.api.response.BoardLikeResponse
import com.example.mediaproject.api.service.BoardLikeService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/media-project/up-down/likes")
class LikeController(
    private val boardLikeService: BoardLikeService
) {

    @ApiOperation("댓글을 남기기")
    @PostMapping
    fun postLike(
//        @RequestAttribute userId: Long,
        @RequestParam userId: Long,
        @RequestParam boardId: Long,
    ): ResponseEntity<BoardLikeResponse> {
        val response = boardLikeService.postLike(boardId, userId)
        return ResponseEntity.ok(response)
    }

    @ApiOperation("보드를 삭제하기")
    @DeleteMapping("/{boardLikeId}")
    fun deleteBoard(
        @PathVariable("boardLikeId") boardLikeId: Long
    ): ResponseEntity<Boolean> {
        val response: Boolean = boardLikeService.deleteLike(boardLikeId)
        return ResponseEntity.ok(response)
    }
}
