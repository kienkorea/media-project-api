//package com.example.mediaproject.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.client.RestTemplate
//import org.springframework.web.util.DefaultUriBuilderFactory
//
//
//@Configuration
//class RestTemplateConfig {
//
//
//    @Bean
//    fun restTemplate(): RestTemplate {
//        val restTemplate = RestTemplate()
//        val STOCK_COMPANY_API = "https://infuser.odcloud.kr/oas/docs?namespace=15049692/v1/15049692/v1/uddi:b0e68394-0183-47f8-8097-cf189b1278ef"
//        val defaultUriBuilderFactory = DefaultUriBuilderFactory(STOCK_COMPANY_API)
//        restTemplate.uriTemplateHandler = defaultUriBuilderFactory
//        return restTemplate
//    }
//}