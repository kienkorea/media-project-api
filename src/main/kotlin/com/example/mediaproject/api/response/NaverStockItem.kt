package com.example.mediaproject.api.response

data class NaverStockItem (
    val itemcode: String,
    val itemname: String,
    val now_val: String,
    val change_val: String,
    val change_rate: String,
    val risefall: String,
    var isBookmarked: Boolean = false
)
