package com.seko0716.springbootstartersecurityoauthvkgoogle

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import javax.annotation.PostConstruct

@SpringBootConfiguration
@EnableAutoConfiguration
class Stopper {
    @PostConstruct
    fun init(): Unit {
        println("ContextStopper init")
    }
}