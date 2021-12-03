package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.SignInRequest
import com.example.mediaproject.api.request.SignUpRequest
import com.example.mediaproject.api.response.AccountResponse
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletResponse


@Service
interface AccountService {
    fun checkDuplicatePhoneNumber(checkDuplicatePhoneNumber: String): Boolean
    fun signUp(signUpRequest: SignUpRequest, httpResponse: HttpServletResponse): AccountResponse
    fun signIn(signInRequest: SignInRequest, httpResponse: HttpServletResponse): AccountResponse

}
