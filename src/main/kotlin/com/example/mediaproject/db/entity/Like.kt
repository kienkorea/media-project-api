package com.example.mediaproject.db.entity

import java.time.LocalDateTime
import javax.persistence.*

class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()

    var boardId: Long = -1
    var userId: Long = -1

}