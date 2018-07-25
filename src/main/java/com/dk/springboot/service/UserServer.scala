package com.dk.springboot.service

import com.dk.springboot.entity.User

trait UserServer {
    def getUsers:List[User]

}
