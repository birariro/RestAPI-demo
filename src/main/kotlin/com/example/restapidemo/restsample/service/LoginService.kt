package com.example.restapidemo.restsample.service

import org.springframework.stereotype.Service

@Service
class SampleLoginService {

    fun validLogin(id:String,pwd:String) : Boolean {
        return (id.isNotBlank() && pwd.isNotBlank())
    }
}