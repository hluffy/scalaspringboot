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

    /**
      * 根据countrycode查询省份信息
      * @param countryCode
      * @return
      */
    @RequestMapping(Array("findbycountrycode"))
    def findByCountryCode(countryCode:Long) = {
        val result = new com.dk.springboot.newresult.Result
        if(countryCode==null){
            result.status = false
            result.message = "参数不能为空"
        }else{
            result.status = true
            result.message = "查询成功"
            result.data = provinceRepository.findByCountryCode(countryCode)
        }
        result

    }

}
