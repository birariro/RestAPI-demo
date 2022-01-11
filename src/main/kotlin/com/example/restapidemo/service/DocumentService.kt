package com.example.restapidemo.service

import org.springframework.stereotype.Service

@Service
class DocumentService {

    //저장소로 취급한다.
    val data = mutableListOf<String>().apply {
        add("hello my name alice")
        add("hello my name bob")
        add("hello my name joy")
        add("hello my name nik")
        add("hello my name zi")
    }

    fun findById(id:Int):String{
        return data[id]
    }
    fun findAll():List<String>{
        return data
    }

}