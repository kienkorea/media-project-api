package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.StockCompanyResponse
import org.springframework.data.domain.Page
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

@Service
class StockCompanyServiceImpl: StockCompanyService {

    private val STOCK_COMPANY_API: String =
        "https://infuser.odcloud.kr/oas/docs?namespace=15049692/v1/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"

    override fun getCompanyStock(): Page<*> {

        val headers = HttpHeaders().apply {
            this.contentType = MediaType.APPLICATION_JSON
        }
        val restTemplate = RestTemplate()
        val entity: HttpEntity<Page<StockCompanyResponse>> = HttpEntity<Page<StockCompanyResponse>>(headers)
        val response = restTemplate.getForObject(STOCK_COMPANY_API, Page::class.java)
        return response!!
    }

    fun getApi(){
        val urlBuilder = StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getKDRSecnInfo") /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키") /*Service Key*/
        urlBuilder.append(
            "&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(
                "-",
                "UTF-8"
            )
        ) /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append(
            "&" + URLEncoder.encode("caltotMartTpcd", "UTF-8") + "=" + URLEncoder.encode(
                "12",
                "UTF-8"
            )
        ) /*11: 유가증권시장, 12: 코스닥시장, 13: 코넥스시장*/
        val url = URL(urlBuilder.toString())
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.setRequestProperty("Content-type", "application/json")
        println("Response code: " + conn.responseCode)
    }
}