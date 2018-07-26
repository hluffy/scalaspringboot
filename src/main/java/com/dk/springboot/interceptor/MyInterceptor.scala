package com.dk.springboot.interceptor

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import org.springframework.web.servlet.{HandlerInterceptor, ModelAndView}

class MyInterceptor extends HandlerInterceptor{

    override def preHandle(request: HttpServletRequest, response: HttpServletResponse, o: scala.Any): Boolean = {
        val session = request.getSession(true)
        println(session.getId)
        if(session.getAttribute("userName")==null){
            response.sendRedirect(request.getContextPath+"/page/login")
            false
        }else{
            println(session.getAttribute("userName"))
            true
        }
    }

    override def postHandle(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, o: scala.Any, modelAndView: ModelAndView): Unit = {

    }

    override def afterCompletion(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, o: scala.Any, e: Exception): Unit = {

    }

}
