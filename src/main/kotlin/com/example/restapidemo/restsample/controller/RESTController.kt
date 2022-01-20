package com.example.restapidemo.restsample.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.common.response.result.body.HatroasDto
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.restsample.controller.dto.LoginDto
import com.example.restapidemo.restsample.controller.dto.LoginResponse
import com.example.restapidemo.restsample.service.DocumentService
import com.example.restapidemo.restsample.service.SampleLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest")
class RESTLoginController {

    @Autowired
    lateinit var responseService : ResponseService
    @Autowired
    lateinit var loginService: SampleLoginService
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto):CommonResult{
        val links = mutableListOf<HatroasDto>().apply {
            add(HatroasDto("home","http://localhost:8080/rest/home"))
            add(HatroasDto("document","http://localhost:8080/rest/document"))
            add(HatroasDto("setting","http://localhost:8080/rest/setting"))
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
        return try{
            val findAll = documentService.getAllDocument()
            return responseService.getListResult(findAll)
        }catch (e:Exception){
            responseService.getFailResult(ErrorCode.DB)
        }

    }
    @GetMapping("/document/{id}")
    fun getDocument(@PathVariable id:Int) : CommonResult{
        return try{
            val findTree = documentService.findByIdAndTree(id)
            val documentThis = findTree["this"]
            val documentOld = findTree["old"]
            val documentNext = findTree["next"]
            val links = mutableListOf<HatroasDto>().apply {

                if(documentOld != "")  add(HatroasDto("old","http://localhost:8080/rest/document/$documentOld"))
                add(HatroasDto("this","http://localhost:8080/rest/document/$id"))
                if(documentNext != "")  add(HatroasDto("next","http://localhost:8080/rest/document/$documentNext"))
            }
            return responseService.getSingleHatroasResult(documentThis, links)

        }catch (e:Exception){
            responseService.getFailResult(ErrorCode.DB)
        }
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

