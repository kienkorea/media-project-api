package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.ChangePasswordRequest
import com.example.mediaproject.api.response.*
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.common.exception.NotFoundException
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.repository.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import kotlin.streams.toList


@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository,
    private val commentRepository: CommentRepository,
    private val commentRepositorySupport: CommentRepositorySupport,
    private val userRepositorySupport: UserRepositorySupport

) : UserService {

    override fun getMe(userId: Long): UserResponse {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        if (foundUser.isDeleted) throw NotFoundException("삭제 된 유저입니다. -> ${foundUser.phoneNumber}")
        return userResponseOf(foundUser)
    }

    override fun getAllMyBoard(userId: Long): List<BoardDetailResponse> {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        return boardRepository.findAllByUserIdOrderByCreatedAtDesc(userId).stream().map { boardDetailResponseOf(it, userId) }.toList()
    }

    override fun getAllMyComment(userId: Long): List<CommentResponse> {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        return commentRepository.findAllByUserIdOrderByCreatedAtDesc(userId).stream()
            .map { commentResponseOf(it, userId) }.toList()
    }

    override fun getMyLikeBoardList(userId: Long): UserAndBoardResponse {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        val boardResponseList: List<BoardDetailResponse> = userRepositorySupport.getMyLikeBoardList(userId)
            .stream().map { boardDetailResponseOf(it, userId) }.toList()
        return ofUserAndBoardResponse(foundUser, boardResponseList)
    }

    @Transactional
    override fun resetPassword(userId: Long, needChangePassword: Boolean): UserResponse {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        if (needChangePassword) {
            foundUser.loginPassWord = BCryptPasswordEncoder().encode("0000")
            foundUser.needChangePassword = true
        }
        return userResponseOf(foundUser)
    }

    @Transactional
    override fun changePassword(userId: Long, changePasswordRequest: ChangePasswordRequest): UserResponse {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }

        val checkMatches = BCryptPasswordEncoder().matches(changePasswordRequest.nowPassword, foundUser.loginPassWord)
        if (!checkMatches) throw BadRequestException("비밀번호가 일치하지 않습니다")

        foundUser.loginPassWord = BCryptPasswordEncoder().encode(changePasswordRequest.newPassword)
        foundUser.needChangePassword = false
        return userResponseOf(foundUser)
    }

    override fun getAllUser(q: String?): List<UserResponse> {
        val userList: List<User> = userRepositorySupport.getAllUser(q)
        return userList.stream().map { userResponseOf(it) }.toList()
    }

}