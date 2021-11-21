package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.service.BoardService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore
import org.springframework.ui.Model
import org.springframework.ui.set

@RequestMapping("/media-project/up-down/boards")
@RestController
class BroadController(
    private val boardService: BoardService
) {

    @PostMapping
    fun postBoard(
        @RequestBody postBoardRequest: PostBoardRequest
    ): ResponseEntity<BoardResponse>{
        val response: BoardResponse = boardService.postBoard(postBoardRequest)
        return ResponseEntity.ok(response)
    }

    @PatchMapping("/{boardId}")
    fun patchBoard(
        @PathVariable("boardId") boardId: Long,
        @RequestBody patchBoardRequest: PatchBoardRequest
    ): ResponseEntity<BoardResponse>{
        val response: BoardResponse = boardService.patchBoard(boardId, patchBoardRequest)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{boardId}")
    fun deleteBoard(
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<Boolean>{
        val response: Boolean = boardService.deleteBoard(boardId)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{boardId}")
    fun findBoardById(
        @PathVariable("boardId") boardId: Long
    ): ResponseEntity<BoardResponse>{
        val response: BoardResponse = boardService.findBoardById(boardId)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/list")
    @ApiImplicitParams(value = [
        ApiImplicitParam(name = "page", value = "페이지 넘버", defaultValue = "", paramType = "query", dataTypeClass = Int::class),
        ApiImplicitParam(name = "size", value = "페이지 크기", defaultValue = "", paramType = "query", dataTypeClass = Int::class),
        ApiImplicitParam(name = "sort", value = "정렬", defaultValue = "", paramType = "query", dataTypeClass = Int::class)
    ])
    fun findAllBoard(
        @ApiIgnore pageable: Pageable,
        @RequestParam("q", required = false) q: String?
    ): ResponseEntity<Page<BoardResponse>> {
        val response: Page<BoardResponse> = boardService.findAllBoard(pageable, q)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/list-board")
    fun findListBoard(model: Model): String{
        model["boards"] = boardService.findBoardList()
        return "board"
    }
}