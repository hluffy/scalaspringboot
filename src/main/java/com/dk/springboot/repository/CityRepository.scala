package com.dk.springboot.repository

import java.util

import com.dk.springboot.entity.City
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository

@Repository
trait CityRepository extends JpaRepository[City,java.lang.Long]{

//    @Query(value="select c from city c left join c.province p on c.provinceCode = p.code")
    def findAll(pageable:Pageable):Page[City]

    /**
      * 根据provincecode查询城市信息
      * @param provinceCode
      * @param pageable
      * @return
      */
    def findByProvinceCode(provinceCode:Long,pageable:Pageable):Page[City]

    /**
      * 根据provincecode和名称查询城市信息
      * @param provinceCode
      * @param name
      * @param pageable
      * @return
      */
    def findByProvinceCodeIsAndNameContaining(provinceCode:Long,name:String,pageable:Pageable):Page[City]

}
