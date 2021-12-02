package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.*
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import com.example.mediaproject.common.exception.NotFoundException
import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.repository.BoardRepository
import kotlin.streams.toList

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository
): UserService {

    override fun getMe(userId: Long): UserResponse {
        val foundUser: User = userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        if (foundUser.isDeleted) throw NotFoundException("삭제 된 유저입니다. -> ${foundUser.phoneNumber}")
        return userResponseOf(foundUser)
    }

    override fun getAllMyBoard(userId: Long): UserAndBoardResponse {
        val foundUser: User = userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        if (foundUser.isDeleted) throw NotFoundException("삭제 된 유저입니다. -> ${foundUser.phoneNumber}")
        val listBoardResponse: List<BoardResponse>  = boardRepository.findAllByUserId(userId).stream().map { boardResponseOf(it) }.toList()
        return  ofUserAndBoardResponse(foundUser, listBoardResponse)
    }

}