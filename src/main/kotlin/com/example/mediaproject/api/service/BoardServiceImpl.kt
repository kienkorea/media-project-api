package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import com.example.mediaproject.api.response.BoardDetailResponse
import com.example.mediaproject.api.response.BoardResponse
import com.example.mediaproject.api.response.boardDetailResponseOf
import com.example.mediaproject.api.response.boardResponseOf
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.repository.BoardRepositorySupport
import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.patchOf
import com.example.mediaproject.db.entity.postOf
import com.example.mediaproject.db.repository.BoardRepository
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
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
    override fun postBoard(postBoardRequest: PostBoardRequest): BoardResponse {
        val foundUser: User = userRepository.findById(postBoardRequest.userId)
            .orElseThrow { throw BadRequestException("유저 정보를 찾을 수 없습니다. -> ${postBoardRequest.userId}") }
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

    override fun findBoardById(boardId: Long): BoardResponse {
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        return boardResponseOf(foundBoard)
    }

    override fun findAllBoard(pageable: Pageable, q: String?): Page<BoardResponse> {
        val boardPage: Page<Board> = boardRepositorySupport.findAllBoardPaging(pageable, q)
        val boardResponseList: List<BoardResponse> = boardPage.content.stream().map { boardResponseOf(it) }.toList()
        return PageImpl(boardResponseList, pageable, boardPage.totalElements)
    }

    override fun findBoardList(): List<BoardResponse> {
        val boardList: List<Board> = boardRepository.findAll()
        return boardList.stream().map { boardResponseOf(it) }.toList()
    }

    override fun getBoardDetail(boardId: Long): BoardDetailResponse {
        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }
        return boardDetailResponseOf(foundBoard)
    }

}