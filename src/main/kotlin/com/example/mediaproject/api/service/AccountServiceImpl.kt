package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.SignInRequest
import com.example.mediaproject.api.request.SignUpRequest
import com.example.mediaproject.api.response.*
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.common.exception.NotFoundException
import com.example.mediaproject.common.utils.normalizePhoneNumber
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.enumerable.UserRole
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletResponse

@Service
class AccountServiceImpl(
    private val userRepository: UserRepository,
    private val tokenService: TokenService

) : AccountService {
    override fun checkDuplicate(checkDuplicatePhoneNumber: String): Boolean {
        val phoneNumber: String = normalizePhoneNumber(checkDuplicatePhoneNumber)
        val foundUserList: MutableList<User> = userRepository.findAllByPhoneNumber(phoneNumber)
        return foundUserList.any { !it.isDeleted }    }

    override fun signUp(signUpRequest: SignUpRequest, httpResponse: HttpServletResponse): AccountResponse {
        val foundList: List<User> = userRepository.findAllByPhoneNumber(signUpRequest.phoneNumber)
        if (foundList.size > 1) throw BadRequestException("회원 가입 중 오류가 발생했습니다. 관리자에게 문의하세요. -> ${signUpRequest.phoneNumber}")
        val user: User = if (foundList.isNotEmpty()) foundList[0]
        else User()
        user.name = signUpRequest.name
        user.email = signUpRequest.email
        user.phoneNumber = signUpRequest.phoneNumber
        user.loginPassWord= BCryptPasswordEncoder().encode(signUpRequest.loginPassword)
        user.isDeleted = false
        user.deletedAt = null
        user.userRole = UserRole.ROLE_USER
        val userResponse: UserResponse = userResponseOf(userRepository.saveAndFlush(user))
        val tokenResponse: TokenResponse = tokenService.refreshTokenByPhoneNumber(httpResponse, userResponse.id)
        return accountResponseOf(userResponse, tokenResponse)
    }

    override fun signIn(signInRequest: SignInRequest, httpResponse: HttpServletResponse): AccountResponse {
        val normalizeNumber = normalizePhoneNumber(signInRequest.phoneNumber)
        val foundUserList: List<User> = this.userRepository.findAllByPhoneNumber(normalizeNumber)
        if (foundUserList.isEmpty()) throw BadRequestException("가입되어 있지 않은 휴대폰 번호입니다. -> ${signInRequest.phoneNumber}")
        val user: User = foundUserList[0]
        val encoder = BCryptPasswordEncoder()
        val checkMatchPassword: Boolean = encoder.matches(signInRequest.loginPassWord, user.loginPassWord)
        if(!checkMatchPassword) throw BadRequestException("비밀 번호를 일치하지 않습니다. 비밀번호를 다시 확인하세요. ")
        if (user.isDeleted) throw NotFoundException("삭제 된 유저입니다. -> ${signInRequest.phoneNumber}")

        val userResponse: UserResponse = userResponseOf(user)
        val tokenResponse: TokenResponse = tokenService.refreshTokenByPhoneNumber(httpResponse, userResponse.id)
        return accountResponseOf(userResponse, tokenResponse)
    }
}