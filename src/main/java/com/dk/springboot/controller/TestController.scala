package com.dk.springboot.controller

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class TestController {

    @GetMapping(Array("/helloworld"))
    def helloWorld:String = {
        "Hello World"
    }

}
