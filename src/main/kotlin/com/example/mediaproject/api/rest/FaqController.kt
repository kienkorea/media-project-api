package com.example.mediaproject.api.rest

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class FaqController {

    @GetMapping("/faq")
    fun faqPage1(model: Model): String {

        return "fag"
    }
}