package com.example.restapidemo.service

import com.example.restapidemo.domain.entity.User
import com.example.restapidemo.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LoginService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun login(id:String,pwd:String): String {

        return userRepository.findByIdOrNull(id)?.email ?: "no"

    }
}