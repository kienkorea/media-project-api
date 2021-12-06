package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository: JpaRepository<Company, Long> {
    fun existsByName(name: String): Boolean
}
