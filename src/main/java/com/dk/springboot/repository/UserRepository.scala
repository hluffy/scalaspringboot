package com.dk.springboot.repository

import java.util

import com.dk.springboot.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait UserRepository extends JpaRepository[User,Integer]{
    def findById(id:Long):User

    def findAll(): util.List[User]


}
