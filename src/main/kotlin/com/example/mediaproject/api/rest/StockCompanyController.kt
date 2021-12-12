package com.example.mediaproject.api.rest

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.CompanyResponse
import com.example.mediaproject.api.service.StockCompanyService
import com.example.mediaproject.db.entity.Company
import io.swagger.annotations.ApiOperation
import org.springframework.http.*
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/media-project/up-down/stocks")
class StockCompanyController(
    private val stockCompanyService: StockCompanyService,
){

    @ApiOperation("모든 회사 리스트 조회 API" +
            "응답 보디에 isBookmarked = true -> 자기가 관심 누른 회사" +
            "응답 보디에 isBookmarked = false -> 자기가 관심 안 하는 회사")
    @GetMapping("/list")
    fun getCompanyStockListByApiKey(
        @RequestAttribute userId: Long,
        @RequestParam("q", required = false) q: String?
    ): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.getCompanyStockData(q, userId))
    }

    @ApiOperation("회사 상세 정보 조회 API")
    @GetMapping("/{companyCode}")
    fun getStockCompanyDetail(
        @PathVariable companyCode: String
    ): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.getCompanyStockDataDetail(companyCode))
    }

    @Deprecated("지금 사용하지 않음")
    @GetMapping("/feed")
    fun feedCompanyStockListByApiKey(nextId: Long): ResponseEntity<List<CompanyResponse>> {
        return ResponseEntity.ok(stockCompanyService.feedCompanyStockData(nextId))
    }

    @Deprecated("지금 사용하지 않음")
    @PostMapping
    fun postCompany(
        @RequestBody companyRequest: CompanyRequest
    ): ResponseEntity<Company> {
        return ResponseEntity.ok(stockCompanyService.postCompany(companyRequest))
    }

    @Deprecated("지금 사용하지 않음")
    @PostMapping("list")
    fun postCompanyList(
        @RequestBody companyRequestList: List<CompanyRequest>
    ): ResponseEntity<List<Company>> {
        return ResponseEntity.ok(stockCompanyService.postCompanyList(companyRequestList))
    }
}