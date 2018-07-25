package com.dk.springboot.repository

import java.util

import com.dk.springboot.entity.User
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
trait UserRepository extends JpaRepository[User,java.lang.Long]{
    def findById(id:Long):User

    def findAll(): util.List[User]

    /**
      *  自定义sql
      * @return
      */
    @Query(value = "select u from users as u")
    def getInfos(): util.List[User]

    /**
      * 根据id查询用户信息,添加分页
      * @param id
      * @return
      */
    @Query(value="select u from users as u where u.id = :id")
    def getInfoById(@Param("id")id:Long,pageable:Pageable):Page[User]

//    @Query(value="select u from users as u where u.id = :#{user.id}")
//    def getInfo(@Param("user")user:User):util.List[User]

    /**
      * 查询所有用户信息，分页，排序
      * @param pageable
      * @return
      */
    @Query(value="select u from users as u")
    def getInfosAsPage(pageable:Pageable):Page[User]


}
