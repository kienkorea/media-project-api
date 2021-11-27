package com.example.mediaproject.api.rest

import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import com.example.mediaproject.api.service.StockCompanyService
import org.springframework.http.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/media-project/up-down/stocks")
@RestController
class StockCompanyController(
    private val stockCompanyService: StockCompanyService,
){

    @GetMapping("/list")
    fun getCompanyStockListByApiKey(
        @RequestParam page: Int,
        @RequestParam perPage: Int
    ): ResponseEntity<PageStockCompanyCustomResponse> {
        return stockCompanyService.getCompanyStockApi(page, perPage)
    }

}