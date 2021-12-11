package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Company
import com.example.mediaproject.db.entity.QCompany
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CompanyRepositorySupport(
    private val jpaQueryFactory: JPAQueryFactory
) {
    private val qCompany: QCompany = QCompany.company

    fun getAllCompanyWithQ(q: String?): List<Company> {
        val where = BooleanBuilder()
        if(q != null && q.isNotEmpty()) where.and(qCompany.name.contains(q))
        return jpaQueryFactory.select(qCompany)
            .from(qCompany)
            .where(where)
            .orderBy(qCompany.name.asc())
            .fetch()
    }
}