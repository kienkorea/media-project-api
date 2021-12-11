package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import org.springframework.stereotype.Service


@Service
interface BoardService{
    fun postBoard(userId: Long, postBoardRequest: PostBoardRequest): BoardResponse
    fun patchBoard(boardId: Long, patchBoardRequest: PatchBoardRequest): BoardResponse
    fun deleteBoard(boardId: Long): Boolean
    fun getBoardDetail(userId: Long, boardId: Long): BoardDetailResponse
    fun findAllBoard(q: String?, sortBy: String): List<BoardDetailResponse>
}
