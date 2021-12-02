package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


@Service
class StockCompanyServiceImpl: StockCompanyService {
    private val STOCK_COMPANY_API: String =
        "https://api.odcloud.kr/api/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"
    private val apiKeyName = "Authorization"
    private val prefixApi = "Infuser"
    private val encodingKeyValue = "HfuRP3AdRtehAtWpYteMoc5wjjozNcvKfrefwehJeIm21KN7WC77OE64b1SuLqsiyMQy2XBnATIhmuFaceJULQ%3D%3D"
    private val decodingKeyValue = "HfuRP3AdRtehAtWpYteMoc5wjjozNcvKfrefwehJeIm21KN7WC77OE64b1SuLqsiyMQy2XBnATIhmuFaceJULQ=="

    fun getCompanyStockApi1(page: Int, perPage: Int): String {
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
        val resultMap = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Map::class.java)
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(resultMap.body)
    }

    override fun getCompanyStockApi(page: Int, perPage: Int): String {

        val result = HashMap<String, Any>()
        var jsonInString = ""
        try {
            val restTemplate = RestTemplate()
            //restTemplate은 Rest방식 api를 호출할 수 있는 spring 내장 클래스이다.
            //json, xml 응답을 모두 받을 수 있다.

            //header 클래스를 정의해 주고, url을 정의해 주고 exchange method로 api를 호출한다.
            val header = HttpHeaders().apply {
                this.contentType = MediaType.parseMediaType("application/json")
//                this.add(apiKeyName, "$prefixApi $encodingKeyValue")
                this.add(apiKeyName, "$prefixApi $decodingKeyValue")
            }

            val entity = HttpEntity<Map<String, Any>>(header)
            val param = "?page=$page&perPage=$perPage"
            val url = STOCK_COMPANY_API + param

            //api를 호출하여 데이터를 MAP타입으로 전달 받는다.
            val resultMap: ResponseEntity<Map<*, *>> =
                restTemplate.exchange(url, HttpMethod.GET, entity, Map::class.java)

            result["statusCode"] = resultMap.statusCodeValue; //http status code를 확인
            result["header"] = resultMap.headers; //헤더 정보 확인
            resultMap.body?.let { result.put("body", it) };
            //result.put("body", resultMap.getBody())로 넣을 수 없었다. null 가능성 때문인 것 같다.

            val test = result["body"]
            //데이터를 string형태로 파싱해줌
            val mapper = ObjectMapper()
            jsonInString = mapper.writeValueAsString(resultMap.body)

        } catch (e: Exception) {
            when (e) {
                is HttpClientErrorException, is HttpServerErrorException -> {
                    result["statusCode"] = "e.getStatusCode()"; //여기랑
                    result["body"] = "e.getStatusText()"; //여기는 kotlin에서 오류가 났다. 그래서 함수를 그냥 따옴표로 감싸버림.. 확인 필요
                    println("error!");
                    println(e.toString());
                }
                else -> {
                    result["statusCode"] = "999";
                    result["body"] = "excpetion오류";
                    println(e.toString());
                }
            }
        }
        return jsonInString
    }

    override fun testOtherStockAPI(): String{
        val encodingKey = "HfuRP3AdRtehAtWpYteMoc5wjjozNcvKfrefwehJeIm21KN7WC77OE64b1SuLqsiyMQy2XBnATIhmuFaceJULQ%3D%3D"
        val urlBuilder = StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getKDRSecnInfo") /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8").toString() + "=서비스키") /*Service Key*/
        urlBuilder.append(
            "&" + URLEncoder.encode(encodingKey, "UTF-8").toString() + "=" + URLEncoder.encode(
                "-",
                "UTF-8")) /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append(
            "&" + URLEncoder.encode("caltotMartTpcd", "UTF-8").toString() + "=" + URLEncoder.encode(
                "12",
                "UTF-8")) /*11: 유가증권시장, 12: 코스닥시장, 13: 코넥스시장*/
        val url = URL(urlBuilder.toString())
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.setRequestProperty("Content-type", "application/json")
        println("Response code: " + conn.responseCode)
        val rd: BufferedReader = if(conn.responseCode in 200..300) {
            BufferedReader(InputStreamReader(conn.inputStream));
        } else {
            BufferedReader(InputStreamReader(conn.errorStream));
        }
        val sb = StringBuilder();
        val line: String? = rd.readLine()
        while (line != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString()

    }

}