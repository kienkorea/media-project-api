package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.BookmarkedCompany
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookmarkedCompanyRepository: JpaRepository<BookmarkedCompany, Long>{
    fun findAllByUserId(userId: Long): MutableList<BookmarkedCompany>
}
