package com.dk.springboot.controller

import javax.annotation.Resource

import com.dk.springboot.entity.User
import com.dk.springboot.repository.UserRepository
import com.dk.springboot.result.Result
import org.springframework.data.domain.Sort.Direction
import org.springframework.data.domain.{PageRequest, Sort}
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("user"))
class UserController @Resource()(val userRepository:UserRepository){

    /**
      * 根据id查询用户信息
      * @param id
      * @return
      */
    @RequestMapping(value=Array("getuserbyid"),method = Array(RequestMethod.GET))
    def getUserById(id:Long) = userRepository.findById(id)

    /**
      * 查询所有用户信息
      * @return
      */
    @GetMapping(Array("getusers"))
    def getUsers = userRepository.findAll

    /**
      * 测试
      * @param user
      * @return
      */
    @RequestMapping(value=Array("getusertest"),method = Array(RequestMethod.GET))
    def getUserTest(user:User) = {
        val result = new Result
        if(user.id==""){
            result.setStatus(false)
            result.setMessage("id不允许为空")
        }else{
            result.setStatus(true)
            result.setData(user)
            result.setMessage("success")
        }
        result
    }

    /**
      * 自定义sql
      * @return
      */
    @GetMapping(Array("getinfos"))
    def getInfos = userRepository.getInfos

    @GetMapping(Array("getinfobyid"))
    def getInfoById(id:Long,page:Int,size:Int) = {
        val sort = new Sort(Direction.DESC,"id")
        val pageable = new PageRequest(page,size,sort)
        userRepository.getInfoById(id,pageable)
    }

//    @GetMapping(Array("getinfo"))
//    def getInfo(user:User) = {
//        println(user)
//        userRepository.getInfo(user)
//    }

    /**
      * 查询所有用户信息，分页，排序
      * @param page
      * @param size
      * @return
      */
    @GetMapping(Array("getinfosaspage"))
    def getInfosAsPage(page:Integer,size:Integer) = {
        var userPage:Int = 0
        var userSize:Int = 5
        val sort = new Sort(Direction.DESC,"id")
        if(page!=null){
            userPage = page
        }
        if(size!=null){
            userSize = size
        }

        val pageable = new PageRequest(userPage,userSize,sort)
        userRepository.getInfosAsPage(pageable)
    }

}
