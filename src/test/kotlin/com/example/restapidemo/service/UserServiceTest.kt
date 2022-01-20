package com.example.restapidemo.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class UserServiceTest {

    @Autowired
    lateinit var userService: UserService
    @Test
    fun validCreateUserId() {

        var id = "asdhjkas"
        val validCreateUserId = userService.validCreateUserId(id)
        assertEquals(true,validCreateUserId)
    }
}