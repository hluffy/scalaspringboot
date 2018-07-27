package com.dk.springboot.controller


import javax.annotation.Resource

import com.dk.springboot.entity.Province
import com.dk.springboot.repository.ProvinceRepository
import com.dk.springboot.result.Result
import org.springframework.data.domain.{PageRequest, Sort}
import org.springframework.data.domain.Sort.Direction
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("province"))
class ProvinceController{
    @Resource
    val provinceRepository:ProvinceRepository = null

    @RequestMapping(value=Array("findall"))
    def findAll(@RequestBody info:Province) = {
        println(info)

        val result = new Result
        result.setStatus(true)
        result.setMessage("查询成功")
        val pageSize = 20
        val pageable = new PageRequest(info.page,pageSize,new Sort(Direction.ASC,"code"))
        if(StringUtils.isEmpty(info.name)||StringUtils.isEmpty(info.name.trim)){
            result.setData(provinceRepository.findAll(pageable))
        }else{
            result.setData(provinceRepository.findByName(info.name.trim,pageable))
        }

        result
    }

}
