package com.dk.springboot.repository

import java.util

import com.dk.springboot.entity.City
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository

@Repository
trait CityRepository extends JpaRepository[City,java.lang.Long]{

//    @Query(value="select c from city c left join c.province p on c.provinceCode = p.code")
    def findAll:util.List[City]

}
