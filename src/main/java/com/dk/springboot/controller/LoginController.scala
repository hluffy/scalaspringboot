package com.dk.springboot.controller

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import com.dk.springboot.entity.User
import com.dk.springboot.result.Result
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestMethod, RestController}

@RestController
class LoginController {
    @RequestMapping(value=Array("login"),method = Array(RequestMethod.POST))
    def login(username:String,password:String,request:HttpServletRequest,response:HttpServletResponse) = {
        val result = new Result
        if(username=="admin"&&password=="admin"){
            val session = request.getSession
            session.setAttribute("userName",username)
            val info = new User
            info.name = username

            result.setStatus(true)
            result.setData(info)
            result.setMessage("登录成功")
        }else{
            result.setStatus(false)
            result.setMessage("用户名或密码错误")
        }
        result
    }

}
