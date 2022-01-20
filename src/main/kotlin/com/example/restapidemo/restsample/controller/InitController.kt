package com.example.restapidemo.restsample.controller

import com.example.restapidemo.restsample.domain.Document
import com.example.restapidemo.restsample.domain.DocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/init")
class InitController {
    @Autowired
    lateinit var documentRepository: DocumentRepository

    @GetMapping
    fun init(){
        initDocument()
    }

    private fun initDocument(){
        val dataList = mutableListOf<String>().apply {
            add("hello my name alice")
            add("hello my name bob")
            add("hello my name joy")
            add("hello my name nik")
            add("hello my name zi")
        }
        for (data in dataList){
            val document:Document = Document(id = 0,text = data)
            documentRepository.save(document)
        }
    }


}
