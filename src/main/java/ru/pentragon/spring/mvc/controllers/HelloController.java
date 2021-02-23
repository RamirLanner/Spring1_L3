package ru.pentragon.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(@RequestParam(name = "name", defaultValue = "Unknown") String username, @RequestParam(defaultValue = "Unknown") String surname) {
//        return String.format("Hello, %s %s!!!", username, surname);
//    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
