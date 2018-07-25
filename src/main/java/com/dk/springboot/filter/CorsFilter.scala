package com.dk.springboot.filter

import javax.servlet._
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component

@Component
class CorsFilter extends Filter{
    override def init(filterConfig: FilterConfig): Unit = {}

    override def destroy(): Unit = {}

    override def doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain): Unit = {
        val response = servletResponse.asInstanceOf[HttpServletResponse]
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        System.out.println("*********************************过滤器被使用**************************");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
