package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping("/hello")   // http://localhost:8081/api/hello/
    public String Hello(){
        return "hello spring boot!";
    }
}
