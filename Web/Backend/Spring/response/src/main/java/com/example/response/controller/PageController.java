package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }
    
    //Response Entity
    
    // ResponseBody를 만들어서 내려줌
    // REST에서는 보통 API Controller를 쓰기 때문에 굳이 필요없긴 함
    @ResponseBody
    @GetMapping(path = "/user")
    public User user(){
        var user = new User();
        user.setAddress("부산");
        user.setName("이대호");
        return user;
    }
    
}
