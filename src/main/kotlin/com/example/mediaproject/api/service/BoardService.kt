package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
interface BoardService{
    fun postBoard(postBoardRequest: PostBoardRequest): BoardResponse
    fun patchBoard(boardId: Long, patchBoardRequest: PatchBoardRequest): BoardResponse
    fun deleteBoard(boardId: Long): Boolean
    fun findBoardById(boardId: Long): BoardResponse
    fun findAllBoard(pageable: Pageable, q: String?): Page<BoardResponse>
    fun findBoardList(): List<BoardResponse>
    fun getBoardDetail(boardId: Long): BoardDetailResponse
    fun patchLikeBoard(boardId: Long, isLiked: Boolean): BoardResponse
}
