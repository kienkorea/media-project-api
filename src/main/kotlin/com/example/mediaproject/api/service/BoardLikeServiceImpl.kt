package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.BoardLikeResponse
import com.example.mediaproject.api.response.boardLikeResponseOf
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.BoardLike
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.likeOf
import com.example.mediaproject.db.repository.BoardRepository
import com.example.mediaproject.db.repository.LikeRepository
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class BoardLikeServiceImpl(
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository,
    private val likeRepository: LikeRepository
) : BoardLikeService {

    override fun postLike(boardId: Long, userId: Long): BoardLikeResponse {
        val foundUser: User = userRepository.findById(userId)
            .orElseThrow { throw BadRequestException("유저 정보를 찾을 수 없습니다. -> $boardId") }
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        val like: BoardLike = likeOf(foundUser, foundBoard)
        return boardLikeResponseOf(likeRepository.save(like))
    }
}