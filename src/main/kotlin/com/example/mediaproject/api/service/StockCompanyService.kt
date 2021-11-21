package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.StockCompanyResponse
import org.springframework.data.domain.Page


interface StockCompanyService {
    fun getCompanyStock(): Page<*>

}
