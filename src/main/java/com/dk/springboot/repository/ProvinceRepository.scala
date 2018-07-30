package com.dk.springboot.repository

import com.dk.springboot.entity.Province
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait ProvinceRepository extends JpaRepository[Province,java.lang.Long]{
    def findAll(pageable:Pageable):Page[Province]

    def findByName(name:String,pageable:Pageable):Page[Province]

    /**
      * 根据countrycode查询省份信息
      * @param countryCode
      * @return
      */
    def findByCountryCode(countryCode:Long):java.util.List[Province]

}
