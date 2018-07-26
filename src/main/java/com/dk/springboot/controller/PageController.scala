package com.dk.springboot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping}


@Controller
@RequestMapping(Array("page"))
class PageController {
    @GetMapping(Array("login"))
    def login: String = "login"

    @GetMapping(Array("main"))
    def toMain: String = "main"
}

