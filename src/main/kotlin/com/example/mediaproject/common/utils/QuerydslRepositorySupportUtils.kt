package com.example.mediaproject.common.utils


import com.querydsl.jpa.JPQLQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

object QuerydslRepositorySupportUtils {
    fun <T> getPage(query: JPQLQuery<T>, pageable: Pageable): Page<T> {
        val results = query
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()
        val total = query.fetchCount()
        return PageImpl(results, pageable, total)
    }

}