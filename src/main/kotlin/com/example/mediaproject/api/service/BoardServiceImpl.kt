package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.response.boardDetailResponseOf
import com.example.mediaproject.api.response.boardResponseOf
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.patchOf
import com.example.mediaproject.db.entity.postOf
import com.example.mediaproject.db.repository.BoardRepository
import com.example.mediaproject.db.repository.BoardRepositorySupport
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import kotlin.streams.toList

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository,
    private val boardRepositorySupport: BoardRepositorySupport,
    private val userRepository: UserRepository
): BoardService {

    @Transactional
    override fun postBoard(userId: Long, postBoardRequest: PostBoardRequest): BoardResponse {
        val foundUser: User = userRepository.findById(userId)
            .orElseThrow { throw BadRequestException("유저 정보를 찾을 수 없습니다. -> $userId") }
        val savedBoard = boardRepository.save(postOf(postBoardRequest, foundUser))
        return boardResponseOf(savedBoard)
    }

    @Transactional
    override fun patchBoard(boardId: Long, patchBoardRequest: PatchBoardRequest): BoardResponse {
        val foundUser: User = userRepository.findById(patchBoardRequest.userId)
        .orElseThrow { throw BadRequestException("유저 정보를 찾을 수 없습니다. -> ${patchBoardRequest.userId}") }
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        patchOf(foundBoard, foundUser, patchBoardRequest)
        return boardResponseOf(foundBoard)
    }

    override fun deleteBoard(boardId: Long): Boolean {
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        boardRepository.delete(foundBoard)
        return !boardRepository.existsBoardById(foundBoard.id)
    }

    override fun findAllBoard(q: String?, sortBy: String): List<BoardDetailResponse> {
        val boardList: List<Board> = boardRepositorySupport.findAllBoard(q, sortBy)
        return boardList.stream().map { boardDetailResponseOf(it) }.toList()
    }

    override fun getBoardDetail(boardId: Long): BoardDetailResponse {
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        return boardDetailResponseOf(foundBoard)
    }

}