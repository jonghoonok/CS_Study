package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {

    @GetMapping(path="/hello")      // http://localhost:8081/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http://localhost:8081/api/get/hi
    public String hi(){
        return "hi";
    }

    // http:localhost:8081/api/get/path-variable/{name}
    @GetMapping(path = "/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : "+ pathName);
        return pathName;
    }

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    @GetMapping(path = "query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + " " + email + age;
    }

    // DTO를 이용하는 방법 : 현업에서 가장 많이 이용됨
    // 요청하는 값에 대한 검증이 편리함
    @GetMapping(path = "query-param3")
    public String queryParam3(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
