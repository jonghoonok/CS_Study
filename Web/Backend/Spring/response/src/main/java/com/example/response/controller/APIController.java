package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class APIController {

    //text
    @GetMapping(path = "/text")
    public String text(@RequestParam String account){
        return account;
    }

    //json
    // req -> object Mapper -> object -> method -> object -> object Mapper -> response
    @PostMapping(path = "/json")
    public User json(@RequestBody User user){
        return user;    // 200 OK
    }

    @PutMapping(path = "/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);  // PUT 요청시 생성되면 201
    }

}
