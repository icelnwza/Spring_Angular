package com.kmitl.kmitl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @GetMapping("hello")
    public String helloSpringBoot(){
        return "Hello Spring Boot";
    }
}
