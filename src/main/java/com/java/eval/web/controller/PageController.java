package com.java.eval.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping("/")
    public String home() {
        return "<h1>Hello world</h1>";
    }
}
