package com.example.mediaproject.api.request

data class PostBoardRequest(
    val userId: Long,
    val title: String,
    val content: String
)