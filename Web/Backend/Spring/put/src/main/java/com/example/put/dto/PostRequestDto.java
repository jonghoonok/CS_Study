package com.example.put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostRequestDto {
    private String name;
    private int age;
    private List<CarDto> carList;

    public String getName() {
        return name;
    }

    public PostRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PostRequestDto setAge(int age) {
        this.age = age;
        return this;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public PostRequestDto setCarList(List<CarDto> carList) {
        this.carList = carList;
        return this;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
