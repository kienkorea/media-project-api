package com.example.mediaproject.db.entity

import com.example.mediaproject.api.request.CommentRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    lateinit var content: String
    var boardId: Long = -1
    var userId: Long = -1

}

fun of(userId: Long, boardId: Long, commentRequest: CommentRequest): Comment{
    return Comment().apply {
        this.userId = userId
        this.boardId = boardId
        this.content = commentRequest.content
    }
}