package com.example.mediaproject

import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class CallStockApiTest {
    private val STOCK_COMPANY_API: String = "https://infuser.odcloud.kr/oas/docs?namespace=15049692/v1/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"


    @Test
    fun testCallStockApi(){
//        val url = "https://infuser.odcloud.kr/oas/docs?namespace=15049692/v1/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"
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
        println("Response code: " + conn.getResponseCode())
        var rd: BufferedReader = if(conn.responseCode in 200..300) {
            BufferedReader(InputStreamReader(conn.inputStream))
        }else {
            BufferedReader(InputStreamReader(conn.errorStream));
        }

        val sb = StringBuilder()
        var line: String?
        while (rd.readLine().also { line = it } != null) {
            sb.append(line)
        }
        rd.close()
        conn.disconnect()
        println(sb.toString())
        }

    @Test
    fun testApi(){

    }
}