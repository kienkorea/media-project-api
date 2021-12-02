package com.example.mediaproject.common.service

import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import com.example.mediaproject.db.entity.User

@Service
class CustomUserDetailService: UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        TODO("Not yet implemented")
    }
}