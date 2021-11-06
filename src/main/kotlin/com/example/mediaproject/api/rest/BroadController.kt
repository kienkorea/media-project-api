package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun findAllBoard(
    ): ResponseEntity<List<BoardResponse>>{
        val response: List<BoardResponse> = boardService.findAllBoard()
        return ResponseEntity.ok(response)
    }
}