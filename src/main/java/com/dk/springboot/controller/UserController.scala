package com.dk.springboot.controller

import com.dk.springboot.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@ComponentScan
@RestController
class UserController @Autowired()(private val userService : UserService){

    @RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
    def list() = {
        userService.findAll
    }

}
