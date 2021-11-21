package com.example.mediaproject.api.response

data class PageStockCompanyCustomResponse (
    val page: Int,
    val perPage: Int,
    val totalCount: Int,
    val currentCount: Int,
    val data: List<StockCompanyResponse> = mutableListOf()
)