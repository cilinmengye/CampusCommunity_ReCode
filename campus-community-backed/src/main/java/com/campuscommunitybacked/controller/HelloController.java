package com.campuscommunitybacked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController指定了与前端打交道的是哪个类，
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
}
