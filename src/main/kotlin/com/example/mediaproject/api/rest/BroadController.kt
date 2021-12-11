package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.service.BoardService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/media-project/up-down/boards")
@RestController
class BroadController(
    private val boardService: BoardService
) {
    @ApiOperation("보드를 올리기")
    @PostMapping
    fun postBoard(
        @RequestAttribute userId: Long,
        @RequestBody postBoardRequest: PostBoardRequest
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.postBoard(userId, postBoardRequest)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드를 편집하기")
    @PatchMapping("/{boardId}")
    fun patchBoard(
        @PathVariable("boardId") boardId: Long,
        @RequestBody patchBoardRequest: PatchBoardRequest
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.patchBoard(boardId, patchBoardRequest)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드를 삭제하기")
    @DeleteMapping("/{boardId}")
    fun deleteBoard(
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<Boolean> {
        val response: Boolean = boardService.deleteBoard(boardId)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드를 상세보기 (댓글 리스트 조회 포함)")
    @GetMapping("/{boardId}/detail")
    fun getBoardDetail(
        @RequestAttribute userId: Long,
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<BoardDetailResponse> {
        val response: BoardDetailResponse = boardService.getBoardDetail(userId, boardId)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드 리스트 조회 && 필터링 기능")
    @GetMapping("/list")
    fun findAllBoard(
        @RequestParam("q", required = false) q: String?,
        @RequestParam("sortBy", required = true) sortBy: String
    ): ResponseEntity<List<BoardDetailResponse>> {
        val response: List<BoardDetailResponse> = boardService.findAllBoard(q, sortBy)
        return ResponseEntity.ok(response)
    }

}