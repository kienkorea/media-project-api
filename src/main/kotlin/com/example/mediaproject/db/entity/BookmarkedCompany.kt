package com.example.mediaproject.db.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class BookmarkedCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    var deletedAt : LocalDateTime = LocalDateTime.now()
    var isDelete: Boolean = false

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var company: Company

}

fun postBookmarkedCompanyOf(user: User, company: Company): BookmarkedCompany {
    return BookmarkedCompany().apply {
        this.user = user
        this.company = company
    }
}