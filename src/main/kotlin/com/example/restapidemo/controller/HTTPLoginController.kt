package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.body.HatroasDto
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/http")
class HTTPLoginController {

    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: LoginService
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto):CommonResult{

        return if (loginService.validLogin(loginDto.id,loginDto.pwd)){
            responseService.getSuccessResult()
        }else{
            responseService.getFailResult(ErrorCode.CHAR_INVALID)
        }
    }
}

