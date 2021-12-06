package com.example.mediaproject.api.response

data class CompanyResponse (
    val name: String,
    val companyCode: String,
    val stockPrice: String,
    val change_val: String,
    val change_rate: String,
    val risefall: String
)

fun companyResponseOf(naverStockItem: NaverStockItem): CompanyResponse{
    return CompanyResponse(
        name = naverStockItem.itemname,
        companyCode = naverStockItem.itemcode,
        stockPrice = naverStockItem.now_val,
        change_val = naverStockItem.change_val,
        change_rate = naverStockItem.change_rate,
        risefall = naverStockItem.risefall
    )
}