package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardResponse
import org.springframework.stereotype.Service

@Service
interface BoardService{
    fun postBoard(postBoardRequest: PostBoardRequest): BoardResponse
    fun patchBoard(boardId: Long, patchBoardRequest: PatchBoardRequest): BoardResponse
    fun deleteBoard(boardId: Long): Boolean
    fun findBoardById(boardId: Long): BoardResponse
    fun findAllBoard(): List<BoardResponse>
}
