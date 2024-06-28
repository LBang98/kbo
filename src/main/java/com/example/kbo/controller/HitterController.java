package com.example.kbo.controller;

import com.example.kbo.data.model.HitterModel;
import com.example.kbo.data.service.HitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HitterController {

    @Autowired
    private HitterService hitterService;

    @GetMapping("/hitter")
    public String gethitters(Model model) {
        List<HitterModel> hitters = hitterService.HitterData();
        model.addAttribute("hitters", hitters);
        return "player/hitter";
    }
}
