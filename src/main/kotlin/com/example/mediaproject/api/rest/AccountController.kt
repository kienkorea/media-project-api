package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.PostUserRequest
import com.example.mediaproject.api.request.SignInRequest
import com.example.mediaproject.api.request.SignUpRequest
import com.example.mediaproject.api.response.AccountResponse
import com.example.mediaproject.api.service.AccountService
import com.example.mediaproject.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RequestMapping("/media-project/up-down/accounts")
@RestController
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping("/sign-up")
    fun signUp(
        httpResponse: HttpServletResponse,
        @RequestBody signUpRequest: SignUpRequest
    ): ResponseEntity<AccountResponse> {
        val response: AccountResponse = accountService.signUp(signUpRequest, httpResponse)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/sign-in")
    fun signIn(
        httpResponse: HttpServletResponse,
        @RequestBody signInRequest: SignInRequest
    ): ResponseEntity<AccountResponse> {
        val checkExistUserId: AccountResponse = accountService.signIn(signInRequest, httpResponse)
        return  ResponseEntity.ok(checkExistUserId)
    }

    @PostMapping("/check-duplicate-userid")
    fun checkDuplicateId(
        @RequestParam phoneNumber: String
    ): ResponseEntity<Boolean> {
        val checkDuplicatePhoneNumber = accountService.checkDuplicate(phoneNumber)
        return  ResponseEntity.ok(checkDuplicatePhoneNumber)
    }
}