package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.service.BoardService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore

@RequestMapping("/media-project/up-down/boards")
@RestController
class BroadController(
    private val boardService: BoardService
) {
    @ApiOperation("보드를 올리기")
    @PostMapping
    fun postBoard(
        @RequestBody postBoardRequest: PostBoardRequest
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.postBoard(postBoardRequest)
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
    @ApiOperation("보드를 조회하기")
    @GetMapping("/{boardId}")
    fun findBoardById(
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.findBoardById(boardId)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드를 상세보기 (댓글 리스트 조회 포함)")
    @GetMapping("/{boardId}/detail")
    fun getBoardDetail(
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<BoardDetailResponse> {
        val response: BoardDetailResponse = boardService.getBoardDetail(boardId)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("보드 리스트 조회 (보드 응답에 댓글 없음)")
    @GetMapping("/list")
    @ApiImplicitParams(
        value = [
            ApiImplicitParam(
                name = "page",
                value = "페이지 넘버",
                defaultValue = "",
                paramType = "query",
                dataTypeClass = Int::class
            ),
            ApiImplicitParam(
                name = "size",
                value = "페이지 크기",
                defaultValue = "",
                paramType = "query",
                dataTypeClass = Int::class
            ),
            ApiImplicitParam(
                name = "sort",
                value = "정렬",
                defaultValue = "",
                paramType = "query",
                dataTypeClass = Int::class
            )
        ]
    )
    fun findAllBoard(
        @ApiIgnore pageable: Pageable,
        @RequestParam("q", required = false) q: String?
    ): ResponseEntity<Page<BoardResponse>> {
        val response: Page<BoardResponse> = boardService.findAllBoard(pageable, q)
        return ResponseEntity.ok(response)
    }

    @ApiOperation("보드를 좋아요 누르기. 한번 누르면 좋아요 되고, 좋아요 된 상태를 다시 누르면 좋아요 해지가 됨 ")
    @PatchMapping("/{boardId}/like")
    fun patchLikeBoard(
        @PathVariable("boardId") boardId: Long,
        @RequestParam(required = true) isLiked: Boolean
    ): ResponseEntity<BoardResponse> {
        val response: BoardResponse = boardService.patchLikeBoard(boardId, isLiked)
        return ResponseEntity.ok(response)
    }
}