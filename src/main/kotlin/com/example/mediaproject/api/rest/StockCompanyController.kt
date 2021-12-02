package com.example.mediaproject.api.rest

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import com.example.mediaproject.api.response.PageStockCompanyCustomResponse
import com.example.mediaproject.api.service.StockCompanyService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.io.StringReader


@RequestMapping("/media-project/up-down/stocks")
@RestController
class StockCompanyController(
    private val stockCompanyService: StockCompanyService,
){

    @GetMapping("/list")
    fun getCompanyStockListByApiKey(
        @RequestParam page: Int,
        @RequestParam perPage: Int
    ): ResponseEntity<JsonObject> {
        val response = stockCompanyService.getCompanyStockApi(page, perPage)
        val parser = Parser()
        val stringBuilder: StringBuilder = StringBuilder(response)
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject
        return ResponseEntity.ok(json)
    }

    @GetMapping("/test")
    fun getCompanyStockListByApiKey1(): ResponseEntity<JsonObject> {
        val response = stockCompanyService.testOtherStockAPI()
        val parser = Parser()
        val stringBuilder: StringBuilder = StringBuilder(response)
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject
        return ResponseEntity.ok(json)
    }

}