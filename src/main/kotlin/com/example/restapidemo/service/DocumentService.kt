package com.example.restapidemo.service

import com.example.restapidemo.domain.DocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DocumentService {

    @Autowired
    lateinit var documentRepository: DocumentRepository


    fun getDocument(id:Int):String{
        return documentRepository.findByIdOrNull(id.toLong())?.text ?: throw Exception()
    }
    fun getAllDocument():List<String>{
        val documentList =  documentRepository.findAll()
        val result = mutableListOf<String>()
        for (document in documentList){
            result.add(document.text)
        }
        if(result.size == 0) return throw Exception()
        return result
    }
    //검색된 내용과 이전, 다음 인덱스를 반환한다.
    fun findByIdAndTree(id:Int) :Map<String,String>{
        val tree = mutableMapOf<String,String>()

        tree["this"] = documentRepository.findByIdOrNull(id.toLong())?.id?.toString() ?: return throw Exception()
        tree["old"] = documentRepository.findByIdOrNull((id-1).toLong())?.id?.toString() ?: ""
        tree["next"] = documentRepository.findByIdOrNull((id+1).toLong())?.id?.toString() ?: ""

        return tree
    }


}