package com.example.mediaproject

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class MediaProjectApiApplication

fun main(args: Array<String>) {
    runApplication<MediaProjectApiApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
