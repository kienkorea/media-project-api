package com.example.mediaproject.db.entity

import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    var updatedAt : LocalDateTime? = null
    lateinit var name: String
    lateinit var email: String
    var likeCount: Long = 0
    var hateCount: Long = 0

}