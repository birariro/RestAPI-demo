package com.example.restapidemo.domain.repository

import com.example.restapidemo.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>{
}