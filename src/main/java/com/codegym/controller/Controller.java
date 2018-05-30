package com.codegym.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/index")
    public String List(){
        return "index";
    }
}
