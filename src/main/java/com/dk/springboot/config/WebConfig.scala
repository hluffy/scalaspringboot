package com.dk.springboot.config

import com.dk.springboot.interceptor.MyInterceptor
import org.springframework.boot.SpringBootConfiguration
import org.springframework.web.servlet.config.annotation.{InterceptorRegistry, WebMvcConfigurerAdapter}

@SpringBootConfiguration
class WebConfig extends WebMvcConfigurerAdapter{
    override def addInterceptors(registry: InterceptorRegistry): Unit = {
        registry.addInterceptor(new MyInterceptor).addPathPatterns("/**").excludePathPatterns("/page/login","/login","/province/*")
    }


}
