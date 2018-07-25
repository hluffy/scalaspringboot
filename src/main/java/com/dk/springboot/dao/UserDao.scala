package com.dk.springboot.dao

import javax.persistence.{EntityManager, PersistenceContext}

import com.dk.springboot.entity.User
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils


/**
  * 普通Dao
  * @param entityManager
  */
@Repository
class UserDao @PersistenceContext()(val entityManager:EntityManager){

    def getUser(user:User) = {
        var jpql = new StringBuffer("select u from users as u where 1=1 ")
        val paramMap:scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map()


        if(!StringUtils.isEmpty(user.name)){
            jpql.append(" and u.name = :name")
            paramMap += ("name" -> user.name)
        }
        val query = entityManager.createQuery(jpql.toString())
        val keys = paramMap.keySet

        for(keyItem <- keys) {
            query.setParameter(keyItem,paramMap(keyItem))
        }

//        query.setFirstResult(pageNo*pageSize).setMaxResults(pageSize).getResultList()
        query.getResultList()


    }



}
