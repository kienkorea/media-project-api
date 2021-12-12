package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.SignInRequest
import com.example.mediaproject.api.request.SignUpRequest
import com.example.mediaproject.api.response.AccountResponse
import com.example.mediaproject.api.service.AccountService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RequestMapping("/media-project/up-down/accounts")
@RestController
class AccountController(
    private val accountService: AccountService
) {
    @ApiOperation("회원 가입")
    @PostMapping("/sign-up")
    fun signUp(
        httpResponse: HttpServletResponse,
        @RequestBody signUpRequest: SignUpRequest
    ): ResponseEntity<AccountResponse> {
        val response: AccountResponse = accountService.signUp(signUpRequest, httpResponse)
        return ResponseEntity.ok(response)
    }
    @ApiOperation("로그인 API")
    @PostMapping("/sign-in")
    fun signIn(
        httpResponse: HttpServletResponse,
        @RequestBody signInRequest: SignInRequest
    ): ResponseEntity<AccountResponse> {
        val response: AccountResponse = accountService.signIn(signInRequest, httpResponse)
        return  ResponseEntity.ok(response)
    }
    @ApiOperation("핸드폰 번호 중복 체크")
    @PostMapping("/check-duplicate-phone-number")
    fun checkDuplicatePhoneNumber(
        @RequestParam phoneNumber: String
    ): ResponseEntity<Boolean> {
        val response: Boolean = accountService.checkDuplicatePhoneNumber(phoneNumber)
        return  ResponseEntity.ok(response)
    }

    @ApiOperation("이름 중복 체크")
    @PostMapping("/check-duplicate-name")
    fun checkDuplicateName(
        @RequestParam username: String
    ): ResponseEntity<Boolean> {
        val response: Boolean = accountService.checkDuplicateName(username)
        return  ResponseEntity.ok(response)
    }

    @ApiOperation("이메일 중복 체크")
    @PostMapping("/check-duplicate-email")
    fun checkDuplicateEmail(
        @RequestParam email: String
    ): ResponseEntity<Boolean> {
        val response: Boolean = accountService.checkDuplicateEmail(email)
        return  ResponseEntity.ok(response)
    }
}