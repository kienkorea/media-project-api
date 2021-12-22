package com.example.mediaproject.common.filter

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import com.example.mediaproject.common.exception.UnauthorizedException
import com.example.mediaproject.common.model.AUTHORIZATION
import com.example.mediaproject.common.model.TOKEN_PREFIX
import com.example.mediaproject.common.utils.sendError
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthorizationFilter(
    authenticationManager: AuthenticationManager?,
    private val userRepository: UserRepository
): BasicAuthenticationFilter(authenticationManager) {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val logger: Logger = LoggerFactory.getLogger(JwtAuthorizationFilter::class.java)
        if (request.getHeader(AUTHORIZATION) == null) {
            chain.doFilter(request, response)
            return }
        val headerAuthorization: String = request.getHeader(AUTHORIZATION)

        if (!headerAuthorization.startsWith(TOKEN_PREFIX)) { // TOKEN_PREFIX == "Bearer "
            logger.debug("토큰이 'Bearer '로 시작하지 않습니다. -> $headerAuthorization")
            chain.doFilter(request, response)
            return }
        try {
            val authentication: Authentication? = getUsernamePasswordAuthentication(request)
            if (authentication == null) {
                sendError(request, response, UnauthorizedException("존재하지 않는 사용자입니다."), HttpStatus.UNAUTHORIZED)
                return
            }
            SecurityContextHolder.getContext().authentication = authentication
        } catch (ex: Exception) {
            ex.printStackTrace()
            sendError(request, response, ex)
            return
        }
        // Continue filter execution
        chain.doFilter(request, response)
    }

    private fun getUsernamePasswordAuthentication(request: HttpServletRequest): Authentication? {
        val logger: Logger = LoggerFactory.getLogger(JwtAuthorizationFilter::class.java)

        val headerAuthorization: String = request.getHeader(AUTHORIZATION)
        val decodedJWT: DecodedJWT = JWT.decode(headerAuthorization.replace(TOKEN_PREFIX, ""))
        val phoneNumber: String = decodedJWT.subject

        val userList: MutableList<User> = userRepository.findAllByPhoneNumber(phoneNumber)
        if (userList.size > 1) {
            logger.info("해당 번호의 유저 데이터가 2개 이상입니다. -> $phoneNumber")
            return null
        } else if (userList.size == 0) {
            logger.info("해당 번호의 유저 데이터 없습니다. -> $phoneNumber")
            return null
        }
        val user: User = userList[0]
        if (user.isDeleted) {
            logger.info("삭제된 계정입니다. -> $phoneNumber")
            return null
        }

        request.setAttribute("user", user)
        request.setAttribute("userId", user.id)

        val roles: MutableList<GrantedAuthority> = mutableListOf()
        roles.add(SimpleGrantedAuthority(user.userRole.toString()))

        return UsernamePasswordAuthenticationToken(user.phoneNumber, null, roles)
    }
}