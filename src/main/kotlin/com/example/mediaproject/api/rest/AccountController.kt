package com.example.mediaproject.api.rest

import com.example.mediaproject.api.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/media-project/up-down/accounts")
@Controller
class AccountController(
    private val userService: UserService
) {
    @GetMapping("/test")
    fun test(model: Model): String{
        return "/Users/phamkien/MediaProjectApi/src/main/resources/templates/sample"
    }
}