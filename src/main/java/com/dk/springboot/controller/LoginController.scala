package com.dk.springboot.controller

import javax.annotation.Resource
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import com.dk.springboot.entity.User
import com.dk.springboot.repository.UserRepository
import com.dk.springboot.result.Result
import com.dk.springboot.util.Md5Util
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestMethod, RestController}

@RestController
class LoginController @Resource()(val userRepository:UserRepository){
    val logger = LoggerFactory.getLogger(classOf[LoginController])

    /**
      * 登录
      * @param username
      * @param password
      * @param request
      * @param response
      * @return
      */
    @RequestMapping(value=Array("login"),method = Array(RequestMethod.POST))
    def login(username:String,password:String,request:HttpServletRequest,response:HttpServletResponse):Result = {
        val result = new Result
        if(username==null||username.isEmpty){
            result.setStatus(false)
            result.setMessage("用户名不可以为空")
            return result
        }
        if(password==null||password.isEmpty){
            result.setStatus(false)
            result.setMessage("密码不可以为空")
            return result
        }

        val user = userRepository.findByNameAndPassword(username,Md5Util.md5String(password))
        if(user!=null){
            val session = request.getSession
            session.setAttribute("userName",username)
            val info = new User
            info.name = username
            result.setStatus(true)
            result.setData(info)
            result.setMessage("登录成功")

            logger.info(username+":登录成功")
        }else{
            result.setStatus(false)
            result.setMessage("用户名或密码错误")
            logger.error("用户名或密码错误！")
        }

        result
    }

    /**
      * 退出
      * @param request
      */
    @GetMapping(Array("logout"))
    def logOut(request:HttpServletRequest): Unit ={
        val session = request.getSession()
        val username = session.getAttribute("userName")
        session.removeAttribute("userName")
        logger.info(username+":登出成功")
    }

}
