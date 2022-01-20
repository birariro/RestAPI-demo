package com.example.restapidemo.restsample.controller

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    lateinit var responseService: ResponseService
    @GetMapping
    fun getHello():CommonResult{
        val dto = SampleDTO("k4keye","인천")
        val dtos = mutableListOf<SampleDTO>().apply {
            add(dto)
            add(dto)
            add(dto)
        }
        return responseService.getListResult(dtos)

    }
}
data class SampleDTO(val name:String, val address:String)