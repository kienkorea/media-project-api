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
    var updatedAt : LocalDateTime? = null

    lateinit var content: String

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var board: Board

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

}

fun of(user: User, board: Board, commentRequest: CommentRequest): Comment{
    return Comment().apply {
        this.user = user
        this.board = board
        this.content = commentRequest.content
    }
}