package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.PostUserRequest
import com.example.mediaproject.api.response.UserResponse
import com.example.mediaproject.api.response.of
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.postOf
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    @Transactional
    override fun registerUser(postUserRequest: PostUserRequest): UserResponse {
        this.checkExistUserId(postUserRequest.userId)
        return of(userRepository.save(postOf(postUserRequest)))
    }

    override fun loginUser(userId: String, password: String): UserResponse {
        val checkExistUserId = userRepository.existsByUserId(userId)
        if (!checkExistUserId) {
            throw BadRequestException("존재하지 않는 유저 아이디입니다. 유저 아이디를 확인해즈세요. -> $userId")
        }
        val foundUser: User = userRepository.findByUserIdAndPassword(userId, password)
            .orElseThrow { BadRequestException("패스워드를 일치하지 않습니다. 패스워드를 확인해즈세요. -> $userId") }
        return of(foundUser)
    }

    // 유저를 등록할 때 userId를 존재하는지 체크
    private fun checkExistUserId(userId: String): Boolean {
        val checkedExistUserId = userRepository.existsByUserId(userId)
        if(checkedExistUserId){
            throw BadRequestException("해당 유저 아이디가 존재합니다. 다른 유저 아이디를 입력해주세요. -> $userId" )
        }
        return true
    }
}