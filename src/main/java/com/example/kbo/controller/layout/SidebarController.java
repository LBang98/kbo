package com.example.kbo.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SidebarController {

    @GetMapping("/side")
    private String side(){

        return "layout/side";
    }
}
