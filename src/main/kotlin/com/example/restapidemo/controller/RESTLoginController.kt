package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.body.HatroasDto
import com.example.restapidemo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest")
class RESTLoginController {

    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: LoginService
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto):CommonResult{
        val links = mutableListOf<HatroasDto>().apply {
            add(HatroasDto("home","http://localhost:8080/home"))
            add(HatroasDto("account","http://localhost:8080/account"))
            add(HatroasDto("setting","http://localhost:8080/setting"))
        }
        val porfile ="http://server.com/doc/home"
        return responseService.getHatroasResult(porfile,links)
    }
}

