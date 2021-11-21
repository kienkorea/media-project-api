package com.example.mediaproject.api.rest

import com.example.mediaproject.api.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/media-project/up-down/accounts")
@RestController
class AccountController(
    private val userService: UserService
) {
    @GetMapping("/login")
    fun test(model: Model): String{

        return "home"
    }

    @GetMapping("/test")
    fun testJSP(model: Model): String{
        model["greeting"] = "Hello Spring MVC"

        return "test"
    }
}