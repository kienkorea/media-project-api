package com.example.mediaproject.api.request

data class PatchBoardRequest(
    val boardId: Long,
    val userId: Long,
    val title: String?,
    val content: String?
)
