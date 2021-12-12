package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.BookmarkedCompany

data class BookmarkedCompanyResponse(
    val id: Long,
    val userId: Long,
    val userName: String,
    val companyId: Long,
    val companyCode: String,
    val companyName: String
)

fun bookmarkedCompanyResponseOf(bookmarkedCompany: BookmarkedCompany): BookmarkedCompanyResponse{
    return BookmarkedCompanyResponse(
        bookmarkedCompany.id,
        bookmarkedCompany.user.id,
        bookmarkedCompany.user.name,
        bookmarkedCompany.company.id,
        bookmarkedCompany.company.companyCode,
        bookmarkedCompany.company.name
    )

}
