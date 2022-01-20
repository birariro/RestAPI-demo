package com.example.restapidemo.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User (
        @Id
        val id:String,
        val pwd:String,
        val email:String
        )