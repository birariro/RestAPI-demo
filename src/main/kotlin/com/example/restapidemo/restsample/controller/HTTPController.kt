package com.example.restapidemo.restsample.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.restsample.controller.dto.LoginDto
import com.example.restapidemo.restsample.controller.dto.LoginResponse
import com.example.restapidemo.restsample.service.DocumentService
import com.example.restapidemo.restsample.service.SampleLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/http")
class HTTPController {

    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: SampleLoginService
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
        return try{
            val findAll = documentService.getAllDocument()
            responseService.getListResult(findAll)
        }catch (e:Exception){
            responseService.getFailResult(ErrorCode.DB)
        }
    }
    @GetMapping("/document/{id}")
    fun getDocument(@PathVariable id:Int) : CommonResult{
        return try{
            val findById = documentService.getDocument(id)
            responseService.getSingleResult(findById)
        }catch (e:Exception){
            responseService.getFailResult(ErrorCode.DB)
        }

    }
}

