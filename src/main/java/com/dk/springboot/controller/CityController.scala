package com.dk.springboot.controller

import javax.annotation.Resource

import com.dk.springboot.newresult.Result
import com.dk.springboot.repository.CityRepository
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("city"))
class CityController {
    @Resource
    val cityRepository:CityRepository = null

    @GetMapping(Array("findall"))
    def findALl = {
        val result = new Result
        result.data = cityRepository.findAll
        result.status = true
        result.message = "查询成功"
        result
    }


}
