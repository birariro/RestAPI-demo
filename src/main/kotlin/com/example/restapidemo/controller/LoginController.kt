package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.controller.dto.LoginDto
import com.example.restapidemo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {
    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: LoginService
    @PostMapping("/login/")
    fun login(@RequestBody loginDto: LoginDto) :CommonResult{
        return responseService.getStringResult(loginService.login(loginDto.id,loginDto.pwd))
    }
}