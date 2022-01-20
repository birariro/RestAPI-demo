package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.domain.entity.User
import com.example.restapidemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var responseService : ResponseService
    @PostMapping
    fun createUser(@RequestBody user: User):CommonResult{
        var res = userService.createUser(user)

        return if(res){
            responseService.getSuccessResult()
        }else{
            responseService.getFailResult("ERR")
        }
    }
    @GetMapping
    fun findUser(){
        userService.findUser()
    }
    @PutMapping
    fun updateUser(){
        userService.updateUser()
    }
    @DeleteMapping
    fun deleteUser(){
        userService.deleteUser()
    }

}