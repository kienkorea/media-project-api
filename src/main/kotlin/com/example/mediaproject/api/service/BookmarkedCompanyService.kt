package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.BookmarkedCompanyResponse

interface BookmarkedCompanyService {
    fun postBookmarkedCompany(userId: Long, companyId: Long): BookmarkedCompanyResponse
    fun deleteBookMarkedCompany(bookMarkedId: Long): Boolean

}
