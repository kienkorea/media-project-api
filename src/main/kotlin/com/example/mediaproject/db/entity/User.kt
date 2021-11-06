package com.example.mediaproject.db.entity

import com.example.mediaproject.api.request.PostUserRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    var updatedAt : LocalDateTime? = null
    lateinit var userId: String
    lateinit var password: String
    lateinit var name: String
    lateinit var email: String
    lateinit var phoneNumber: String

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var boardList: MutableList<Board> = mutableListOf()
}
fun postOf(postUserRequest: PostUserRequest): User{
    return User().apply {
        this.userId = postUserRequest.userId
        this.name = postUserRequest.name
        this.email = postUserRequest.email
        this.password = postUserRequest.password
        this.phoneNumber = postUserRequest.phoneNumber
    }
}