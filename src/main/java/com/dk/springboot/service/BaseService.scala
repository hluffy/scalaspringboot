package com.dk.springboot.service

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.beans.factory.annotation.Autowired
import scala.reflect.ClassTag
import java.lang.Long
import org.springframework.data.domain.Page
import java.util.List
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import java.lang.Boolean
import org.springframework.data.domain.PageRequest

@Service
abstract class BaseService[T: ClassTag] {
    /** spring data jpa dao*/
    @Autowired val jpaRepository: JpaRepository[T, Long] = null


    /**
      * @description 查询所有数据
      * @return List[T]
      */
    def findAll[S <: T]: List[T] = jpaRepository.findAll


    /**
      * @description 查询分页
      * @param page 起始页
      * @param pageSize 每页大小
      * @return Page[T]
      */
    def page[S <: T](page: Int, pageSize: Int): Page[T] = {
        val rpage = if (page < 1) 1 else page;
        val rpageSize = if (pageSize < 1) 5 else pageSize;
        jpaRepository.findAll(new PageRequest(rpage - 1, pageSize))
    }

}
