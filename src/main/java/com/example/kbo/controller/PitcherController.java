package com.example.kbo.controller;

import com.example.kbo.data.model.PitcherModel;
import com.example.kbo.data.service.PitcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PitcherController {


    @Autowired
    private PitcherService pitcherService;

    @GetMapping("/pitcher")
    public String getPlayers(Model model) {
        List<PitcherModel> Pitcherplayers = pitcherService.PitcherData();
        model.addAttribute("Pitcherplayers", Pitcherplayers);

        return "player/pitcher";
    }
}
