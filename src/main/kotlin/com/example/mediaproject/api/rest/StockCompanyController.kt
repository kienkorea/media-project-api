package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.CompanyResponse
import com.example.mediaproject.api.service.StockCompanyService
import com.example.mediaproject.db.entity.Company
import org.springframework.data.domain.Pageable
import org.springframework.http.*
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/media-project/up-down/stocks")
class StockCompanyController(
    private val stockCompanyService: StockCompanyService,
){

    @GetMapping("/list")
    fun getCompanyStockListByApiKey(pageable: Pageable): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.getCompanyStockData(pageable))
    }

    @GetMapping("/{companyCode}")
    fun getStockCompanyDetail(
        @PathVariable companyCode: String
    ): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.getCompanyStockDataDetail(companyCode))
    }

    @GetMapping("/feed")
    fun feedCompanyStockListByApiKey(nextId: Long): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.feedCompanyStockData(nextId))
    }

    @PostMapping
    fun postCompany(
        @RequestBody companyRequest: CompanyRequest
    ): ResponseEntity<Company> {
        return ResponseEntity.ok(stockCompanyService.postCompany(companyRequest))
    }
}