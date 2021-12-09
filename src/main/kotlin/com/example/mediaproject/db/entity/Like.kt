package com.example.mediaproject.db.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var board: Board

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

    var isLiked: Boolean = false
}

fun likeOf(user: User, board: Board): BoardLike{
    return BoardLike().apply {
        this.user = user
        this.board = board
        this.isLiked = true
    }
}