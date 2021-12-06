package com.example.mediaproject.api.response

class NaverStockResponse {
    val item_list: MutableList<NaverStockItem> = mutableListOf()
    lateinit var code: String
}