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
    @ApiOperation("보드를 편집하기, 자기가 쓴 보드만 편집할 수 있음")
    @PatchMapping("/{boardId}")
    fun patchBoard(
        @RequestAttribute userId: Long,
        @PathVariable("boardId") boardId: Long,
        @RequestBody patchBoardRequest: PatchBoardRequest
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.patchBoard(boardId, patchBoardRequest, userId)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드를 삭제하기, 자기가 쓴 보드만 삭제할 수 있음")
    @DeleteMapping("/{boardId}")
    fun deleteBoard(
        @RequestAttribute userId: Long,
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
    @ApiOperation("보드 리스트 조회 && 필터링 기능. 소트 파라미터 sortBy=createdAt(최신 탭) && sortBy=likeCount(인기 탭)")
    @GetMapping("/list")
    fun findAllBoard(
        @RequestAttribute userId: Long,
        @RequestParam("q", required = false) q: String?,
        @RequestParam("sortBy", required = true) sortBy: String
    ): ResponseEntity<List<BoardDetailResponse>> {
        val response: List<BoardDetailResponse> = boardService.findAllBoard(q, sortBy, userId)
        return ResponseEntity.ok(response)
    }

}