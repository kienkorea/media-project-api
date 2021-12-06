package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.CompanyResponse
import com.example.mediaproject.api.response.NaverStockItem
import com.example.mediaproject.api.response.NaverStockResponse
import com.example.mediaproject.api.response.companyResponseOf
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.Company
import com.example.mediaproject.db.entity.companyOf
import com.example.mediaproject.db.repository.CompanyRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import retrofit2.Response
import java.lang.StringBuilder


@Service
class StockCompanyServiceImpl(
    private val naverStockPriceService: NaverStockPriceService,
    private val companyRepository: CompanyRepository
): StockCompanyService {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun getCompanyStockData(pageable: Pageable): List<CompanyResponse> {
        val companyList: List<Company> = companyRepository.findAll()

        val naverStockItemList: List<NaverStockItem> = requestToNaverStock(companyList)

        return naverStockItemList.map { companyResponseOf(it) }
    }

    override fun feedCompanyStockData(nextId: Long): List<CompanyResponse> {
        TODO("Not yet implemented")
    }

    private fun requestToNaverStock(companyList: List<Company>): List<NaverStockItem> {
        val stringBuilder = StringBuilder("naver_stock_codeList=")
        companyList.forEach { stringBuilder.append(it.companyCode+"%7C") }

        val response: Response<NaverStockResponse> = naverStockPriceService.getStockPrice(stringBuilder.toString()).execute()
        return response.body()?.item_list ?: listOf()
    }

    override fun postCompany(companyRequest: CompanyRequest): Company {
        if(companyRepository.existsByName(companyRequest.name))
            throw BadRequestException("해당 주식 회사 이름이 존재합니다. ->${companyRequest.name}")
        return companyRepository.save(companyOf(companyRequest))
    }
}