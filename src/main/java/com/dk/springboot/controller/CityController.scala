package com.dk.springboot.controller

import javax.annotation.Resource

import com.dk.springboot.entity.City
import com.dk.springboot.newresult.Result
import com.dk.springboot.repository.CityRepository
import org.springframework.data.domain.Sort.Direction
import org.springframework.data.domain.{PageRequest, Sort}
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.{GetMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(Array("city"))
class CityController {
    @Resource
    val cityRepository:CityRepository = null

    @RequestMapping(Array("findall"))
    def findCity(@RequestBody info:City) = {
        val result = new Result
        result.status = true
        result.message = "查询成功"
        val pageSize = 20
        val pageable = new PageRequest(info.page,pageSize,new Sort(Direction.ASC,"code"))
        if(StringUtils.isEmpty(info.name)||StringUtils.isEmpty(info.name.trim)){
            result.data = cityRepository.findByProvinceCode(info.provinceCode,pageable)
        }else{
            result.data = cityRepository.findByProvinceCodeIsAndNameContaining(info.provinceCode,info.name,pageable)
        }

        result
    }


}
