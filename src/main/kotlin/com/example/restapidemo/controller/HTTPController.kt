package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.controller.dto.LoginDto
import com.example.restapidemo.controller.dto.LoginResponse
import com.example.restapidemo.service.DocumentService
import com.example.restapidemo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/http")
class HTTPController {

    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: LoginService
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto):CommonResult{

        return if (loginService.validLogin(loginDto.id,loginDto.pwd)){
            responseService.getSingleResult(LoginResponse(id = loginDto.id, jwt = "jwt:s67dsf:jasdk8iop234:odj21389"))
        }else{
            responseService.getFailResult(ErrorCode.CHAR_INVALID)
        }
    }


    @Autowired
    lateinit var documentService: DocumentService

    @GetMapping("/document")
    fun getALLDocument():CommonResult{
        val findAll = documentService.findAll()
        return responseService.getListResult(findAll)
    }
    @GetMapping("/document/{id}")
    fun getDocument(@PathVariable id:Int) : CommonResult{
        val findById = documentService.findById(id)
        return responseService.getSingleResult(findById)
    }
}

