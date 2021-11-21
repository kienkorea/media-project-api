package com.example.mediaproject.api.rest

import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import com.example.mediaproject.api.response.StockCompanyResponse
import com.example.mediaproject.api.service.StockCompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import springfox.documentation.annotations.ApiIgnore


@RequestMapping("/media-project/up-down/stocks")
@RestController
class StockCompanyController(
    private val stockCompanyService: StockCompanyService,
){
    private val restTemplate: RestTemplate = RestTemplate()
    private final val STOCK_COMPANY_API = "https://infuser.odcloud.kr/oas/docs?namespace=15049692/v1/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"


    @GetMapping
    fun getCompanyStock(
    ): ResponseEntity<Page<*>>{
        val response: Page<*> = stockCompanyService.getCompanyStock()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/test")
    fun getAllCompanyStock(
    ): ResponseEntity<PageStockCompanyCustomResponse> {
        val response = restTemplate.getForObject(STOCK_COMPANY_API, PageStockCompanyCustomResponse::class.java)
        return ResponseEntity.ok(response)
    }

}