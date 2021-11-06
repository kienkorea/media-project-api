package com.example.mediaproject.api.request

data class PostUserRequest(
    val userId: String,
    val password: String,
    val name: String,
    val email: String,
    val phoneNumber: String
)