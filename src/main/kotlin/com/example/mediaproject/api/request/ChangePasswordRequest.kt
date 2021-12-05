package com.example.mediaproject.api.request

data class ChangePasswordRequest(
    var nowPassword: String,
    var newPassword: String
    )
