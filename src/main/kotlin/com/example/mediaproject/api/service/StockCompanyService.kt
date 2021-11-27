package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import org.springframework.http.ResponseEntity


interface StockCompanyService {
    fun getCompanyStockApi(page: Int, perPage: Int): ResponseEntity<PageStockCompanyCustomResponse>

}
