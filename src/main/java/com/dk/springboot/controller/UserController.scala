package com.dk.springboot.controller

import javax.annotation.Resource

import collection.JavaConverters._
import com.dk.springboot.entity.User
import com.dk.springboot.repository.UserRepository
import com.dk.springboot.result.Result
import com.fasterxml.jackson.databind.util.JSONPObject
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("user"))
class UserController @Resource()(val userRepository:UserRepository){

    /**
      * 根据id查询用户信息
      * @param id
      * @return
      */
    @RequestMapping(value=Array("getuserbyid"),method = Array(RequestMethod.GET))
    def getUserById(id:Long) = userRepository.findById(id)

    /**
      * 查询所有用户信息
      * @return
      */
    @GetMapping(Array("getusers"))
    def getUsers = userRepository.findAll

    /**
      * 测试
      * @param user
      * @return
      */
    @RequestMapping(value=Array("getusertest"),method = Array(RequestMethod.GET))
    def getUserTest(user:User) = {
        val result = new Result
        if(user.id==""){
            result.status = false
            result.message = "id不允许为空"
        }else{
            result.status = true
            result.message = "success"
            result.data = user
        }

        result
    }

}
