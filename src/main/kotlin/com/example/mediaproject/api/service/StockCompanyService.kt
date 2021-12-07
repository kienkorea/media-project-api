package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.CompanyResponse
import com.example.mediaproject.db.entity.Company
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
interface StockCompanyService {
    fun getCompanyStockData(pageable: Pageable): List<CompanyResponse>
    fun feedCompanyStockData(nextId: Long): List<CompanyResponse>
    fun postCompany(companyRequest: CompanyRequest): Company
    fun getCompanyStockDataDetail(companyCode: String): List<CompanyResponse>
}
