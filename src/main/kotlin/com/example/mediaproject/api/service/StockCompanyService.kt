package com.example.mediaproject.api.service


interface StockCompanyService {
    fun getCompanyStockApi(page: Int, perPage: Int): String

    fun testOtherStockAPI(): String
}
