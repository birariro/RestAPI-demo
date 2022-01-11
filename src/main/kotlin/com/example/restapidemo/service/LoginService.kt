package com.example.restapidemo.service

import com.example.restapidemo.controller.dto.LoginDto
import org.springframework.stereotype.Service

@Service
class LoginService {

    fun validLogin(id:String,pwd:String) : Boolean {
        return (id.isNotBlank() && pwd.isNotBlank())
    }
}