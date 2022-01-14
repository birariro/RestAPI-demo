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
    //검색된 내용과 이전, 다음 인덱스를 반환한다.
    fun findByIdAndTree(id:Int) :Map<String,String>{

        val item_this = data[id]
        val item_old = if ((id-1) >= 0)  "${id-1}" else  ""
        val item_new = if ((id+1) < data.count() )"${id+1}"  else  ""
        val tree = mutableMapOf<String,String>()
        tree.put("this",item_this)
        tree.put("old",item_old)
        tree.put("new",item_new)
        return tree
    }


}