package com.dk.springboot.controller

import javax.annotation.Resource

import com.dk.springboot.repository.CityRepository
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("city"))
class CityController {
    @Resource
    val cityRepository:CityRepository = null

    @GetMapping(Array("findall"))
    def findALl = cityRepository.findAll


}
