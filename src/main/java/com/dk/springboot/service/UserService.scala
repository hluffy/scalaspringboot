package com.dk.springboot.service

import com.dk.springboot.entity.User
import com.dk.springboot.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService extends BaseService[User]{
    @Autowired var userRepository: UserRepository = _

}
