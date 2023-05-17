package com.example.myfirstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//public class HelloController {
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello!";
//    }
//}

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }
}