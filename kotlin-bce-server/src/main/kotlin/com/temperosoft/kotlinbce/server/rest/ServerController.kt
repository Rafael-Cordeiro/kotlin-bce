package com.temperosoft.kotlinbce.server.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testcontroller")
class ServerController {

    @GetMapping("/test")
    fun test() : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("saporra rodou")
    }

}