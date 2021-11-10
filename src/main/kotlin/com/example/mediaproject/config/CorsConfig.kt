package com.example.mediaproject.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class CorsConfig: WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        super.addCorsMappings(registry)
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .maxAge(3000)
    }
}