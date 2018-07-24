package com.dk.springboot.repository

import com.dk.springboot.entity.User
import org.springframework.data.jpa.repository.JpaRepository

trait UserRepository extends JpaRepository[User,Long]
