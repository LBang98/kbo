package com.example.kbo.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/main")
    public String main(){
        return "layout/main";
    }


}


