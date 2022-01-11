package com.example.restapidemo.service

import org.springframework.stereotype.Service

@Service
class LoginService {

    fun validLogin(id:String,pwd:String) : Boolean{
        return id.isNotBlank() && pwd.isNotBlank()
    }
}