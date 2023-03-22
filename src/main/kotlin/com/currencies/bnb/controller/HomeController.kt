package com.currencies.bnb.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HomeController {

    @GetMapping
    fun homepage(): String {
        return "<h2>Home page of Spring Boot application</h2>\n" +
                "    <a href=\"http://localhost:8080/api/currencies\">Currencies</a>"
    }
}