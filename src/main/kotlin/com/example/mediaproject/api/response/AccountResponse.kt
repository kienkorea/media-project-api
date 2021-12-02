package com.example.mediaproject.api.response

import com.example.mediaproject.common.utils.maskPhoneNumber

data class AccountResponse(
    var userId: Long,
    var phoneNumber: String,
    var name: String,
    var authorization: TokenResponse
)

fun accountResponseOf(userResponse: UserResponse, tokenResponse: TokenResponse): AccountResponse{
    return AccountResponse(
        userResponse.id,
        maskPhoneNumber(userResponse.phoneNumber),
        userResponse.name,
        tokenResponse
    )
}