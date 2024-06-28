package com.example.kbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "users/login";
    }

    @GetMapping("/frame")
    public String main(){
        return "layout/frame";
    }


}
