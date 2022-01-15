package com.example.restapidemo.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepository :JpaRepository<Document,Long>{
}