package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper는 getter method를 활용한다
        // object mapper를 활용할 때는 getter를 제외하고는 메서드에 get을 붙이지 말 것
        var user = new User("jonghoon", 21, "010-2321-1245");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper는 default constructor를 필요로 한다
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
