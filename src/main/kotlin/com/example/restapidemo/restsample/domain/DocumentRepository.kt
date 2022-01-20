package com.example.restapidemo.restsample.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepository :JpaRepository<Document,Long>{
}