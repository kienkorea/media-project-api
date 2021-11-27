package com.example.mediaproject.api.response

data class PageStockCompanyCustomResponse (
    var page: Int,
    var perPage: Int,
    var totalCount: Int,
    var currentCount: Int,
    var data: List<StockCompanyResponse> = mutableListOf()
)