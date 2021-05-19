package com.example.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class DeleteAPIController {

    @DeleteMapping(path = "/delete/{userId}")
    // GET과 동일하나 내부 동작이 삭제일 뿐
    // DELETE는 요청하는 값이 작기 때문에 DTO보다는 pathvariable이나 queryparam을 권장
    public void delete(@PathVariable String userId, @RequestParam String account){

        System.out.println(userId);
        System.out.println(account);
    }
}
