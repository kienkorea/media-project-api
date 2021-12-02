package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.UserResponse
import com.example.mediaproject.api.response.userResponseOf
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import com.example.mediaproject.common.exception.NotFoundException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun getMe(userId: Long): UserResponse {
        val foundUser: User = userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        if (foundUser.isDeleted) throw NotFoundException("삭제 된 유저입니다. -> ${foundUser.phoneNumber}")
        return userResponseOf(foundUser)
    }

}