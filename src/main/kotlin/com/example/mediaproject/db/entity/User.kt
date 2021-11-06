package com.example.mediaproject.db.entity

import com.example.mediaproject.api.request.PostUserRequest
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    lateinit var userId: String
    lateinit var password: String
    lateinit var name: String
    lateinit var email: String
    lateinit var phoneNumber: String
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