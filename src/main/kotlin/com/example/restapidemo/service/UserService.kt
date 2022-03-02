package com.example.restapidemo.service

import com.example.restapidemo.common.response.ResponseService
import com.example.restapidemo.common.response.result.body.CommonResult
import com.example.restapidemo.domain.entity.User
import com.example.restapidemo.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(user: User):Boolean{
        if(validCreateUserId(user.id)) return false
        if(validUserEmail(user.email)) return false

        userRepository.save(user)

        return true
    }
    fun validCreateUserId(id:String) : Boolean{
        // 길이 체크
        if (id.length < 6) return false
        //영문자, 숫자만 허용
        val regex = Regex("^[a-zA-Z0-9]*\$")
        if (!id.matches(regex)) return false

        //디비에 없는지 체크
        userRepository.findByIdOrNull(id) ?: return false

        return true
    }
    fun validUserEmail(email:String):Boolean{
        //이메일 형식 체크
        val regex = Regex("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\$\n")
        if (!email.matches(regex)) return false
        return true
    }
    fun findUser(){
        userRepository.findAll()
    }
    fun updateUser(){

    }
    fun deleteUser(){

    }


}