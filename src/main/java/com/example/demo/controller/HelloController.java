package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Injection de la propriété depuis application.yml
    @Value("${greeting.message}")
    private String greetingMessage;

    @RequestMapping("/")
    public String hello() {
        return greetingMessage;
    }
}
