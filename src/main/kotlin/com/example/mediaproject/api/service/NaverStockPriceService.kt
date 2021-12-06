package com.example.mediaproject.api.service

import com.example.mediaproject.api.response.NaverStockResponse
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

@Service
interface NaverStockPriceService {
    @GET("item/item_right_ajax.naver?type=recent&page=1&code=035720")
    fun getStockPrice(@Header("cookie") cookie: String): Call<NaverStockResponse>
}