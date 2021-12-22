package com.example.mediaproject.db.entity

import com.example.mediaproject.api.request.CompanyRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()

    lateinit var name: String
    @Column(unique = true)
    var companyCode: String = ""

    @OneToMany(mappedBy = "company" , fetch = FetchType.LAZY)
    var bookmarkedCompanyList: List<BookmarkedCompany> = mutableListOf()

    lateinit var companyImageUrl: String
    lateinit var imageUrl: String


}

fun companyOf(companyRequest: CompanyRequest): Company{
    return Company().apply {
        this.name = companyRequest.name
        this.companyCode = companyRequest.companyCode
    }
}
