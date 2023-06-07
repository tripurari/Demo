package com.natwest.payment.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/helloWorld")
    public String sendGreetings() {
        return "Hello, World!";
    }
}