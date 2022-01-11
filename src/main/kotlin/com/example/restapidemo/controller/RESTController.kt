package com.example.restapidemo.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.body.HatroasDto
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.controller.dto.LoginDto
import com.example.restapidemo.controller.dto.LoginResponse
import com.example.restapidemo.service.DocumentService
import com.example.restapidemo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
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
            add(HatroasDto("setting","http://localhost:8080/document"))
            add(HatroasDto("setting","http://localhost:8080/setting"))
        }
        return if (loginService.validLogin(loginDto.id,loginDto.pwd)){
            responseService.getSingleHatroasResult(data = LoginResponse(id = loginDto.id, jwt = "jwt:s67dsf:jasdk8iop234:odj21389"), list = links)
        }else{
            responseService.getFailResult(ErrorCode.CHAR_INVALID)
        }
    }


    @Autowired
    lateinit var documentService:DocumentService

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
    @PostMapping("/document")
    fun postDocument(@RequestBody newDoc:String){

    }
    @PutMapping("/document")
    fun putDocument(@RequestBody id:Int, newDoc:String){

    }
    @DeleteMapping("/document/{id}")
    fun deleteDocument(@PathVariable id:Int){

    }
}

