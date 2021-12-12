package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.BookmarkedCompanyResponse
import com.example.mediaproject.api.response.bookmarkedCompanyResponseOf
import com.example.mediaproject.common.exception.NotFoundException
import com.example.mediaproject.db.entity.BookmarkedCompany
import com.example.mediaproject.db.entity.Company
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.postBookmarkedCompanyOf
import com.example.mediaproject.db.repository.BookmarkedCompanyRepository
import com.example.mediaproject.db.repository.CompanyRepository
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class BookmarkedCompanyServiceImpl(
    private val bookmarkedCompanyRepository: BookmarkedCompanyRepository,
    private val userRepository: UserRepository,
    private val companyRepository: CompanyRepository
) : BookmarkedCompanyService {

    override fun postBookmarkedCompany(userId: Long, companyId: Long): BookmarkedCompanyResponse {
        val foundUser: User =
            userRepository.findById(userId).orElseThrow { NotFoundException("유저 정보를 찾을 수 없습니다. -> $userId") }
        val foundCompany: Company =
            companyRepository.findById(companyId).orElseThrow { NotFoundException("회사 정보를 찾을 수 없습니다. -> $userId") }
        val bookmarkedCompany: BookmarkedCompany = postBookmarkedCompanyOf(foundUser, foundCompany)
        return bookmarkedCompanyResponseOf(bookmarkedCompanyRepository.save(bookmarkedCompany))
    }

    override fun deleteBookMarkedCompany(bookMarkedId: Long): Boolean {
        val foundCompany: BookmarkedCompany = bookmarkedCompanyRepository.findById(bookMarkedId)
            .orElseThrow { NotFoundException("관심 회사 정보를 찾을 수 없습니다. -> $bookMarkedId") }
        bookmarkedCompanyRepository.delete(foundCompany)
        return !bookmarkedCompanyRepository.existsById(foundCompany.id)
    }


}