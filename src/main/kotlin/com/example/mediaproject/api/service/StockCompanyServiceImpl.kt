package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class StockCompanyServiceImpl: StockCompanyService {
    private val STOCK_COMPANY_API: String =
        "https://api.odcloud.kr/api/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"
    private val apiKeyName = "Authorization"
    private val prefixApi = "Infuser"
    private val encodingKeyValue = "HfuRP3AdRtehAtWpYteMoc5wjjozNcvKfrefwehJeIm21KN7WC77OE64b1SuLqsiyMQy2XBnATIhmuFaceJULQ%3D%3D∂"
    private val decodingKeyValue = "HfuRP3AdRtehAtWpYteMoc5wjjozNcvKfrefwehJeIm21KN7WC77OE64b1SuLqsiyMQy2XBnATIhmuFaceJULQ=="

    override fun getCompanyStockApi(page: Int, perPage: Int): ResponseEntity<PageStockCompanyCustomResponse> {
        val headers = HttpHeaders().apply {
            this.contentType = MediaType.APPLICATION_JSON
//            this.add(apiKeyName, "$prefixApi $encodingKeyValue")
            this.add(apiKeyName, "$prefixApi $decodingKeyValue")
        }
        val restTemplate = RestTemplate()
        val requestEntity: HttpEntity<PageStockCompanyCustomResponse> =
            HttpEntity<PageStockCompanyCustomResponse>(headers)
        val param = "?page=$page&perPage=$perPage"
        val url = STOCK_COMPANY_API + param
        return restTemplate.exchange(
            url, HttpMethod.GET, requestEntity, PageStockCompanyCustomResponse::class.java)
    }


}