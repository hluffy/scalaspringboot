package com.dk.springboot.controller


import javax.annotation.Resource

import com.dk.springboot.repository.UserRepository

import collection.JavaConverters._
import com.dk.springboot.service.UserServer
import org.springframework.web.bind.annotation._

@RestController
class TestController @Resource()(val userServer:UserServer,val userRepository:UserRepository){


    @GetMapping(Array("/helloworld"))
    def helloWorld = "Hello World"



//    @RequestMapping(value = Array("/getusers"),method = Array(RequestMethod.GET))
//    def getUser = {
//        val infos = userServer.getUsers
//        println(infos)
//        infos
//    }

    @GetMapping(Array("/getinfo2"))
    def getInfo2() = Map("pbx" -> "admin", "method" -> "s").asJava

//    All(id:Long) = userDao.findOne(id)

    @GetMapping(Array("/findbyid"))
    def gindById(id:Long) = userRepository.findById(id)

    @GetMapping(Array("/findall"))
    def findAll = userRepository.findAll


}
