package com.example.mediaproject.api.response

import com.example.mediaproject.db.entity.Company

data class CompanyResponse (
    val name: String,
    val companyCode: String,
    val stockPrice: String,
)

fun companyResponseOf(naverStockItem: NaverStockItem): CompanyResponse{
    return CompanyResponse(
        name = naverStockItem.itemname,
        companyCode = naverStockItem.itemcode,
        stockPrice = naverStockItem.now_val
    )
}