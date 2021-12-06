package com.example.mediaproject.config

import com.example.mediaproject.api.service.NaverStockPriceService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class RetrofitConfig {
    @Bean
    fun naverStockPriceService(objectMapper: ObjectMapper?): NaverStockPriceService {
        val retrofit = Retrofit.Builder().baseUrl("https://finance.naver.com/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper!!))
            .build()
        return retrofit.create(NaverStockPriceService::class.java)
    }
}