package com.example.kbo.controller.player;

import com.example.kbo.data.model.HitterModel;
import com.example.kbo.data.service.HitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HitterController {

    @Autowired
    private HitterService hitterService;

    @GetMapping("/hitter")
    public List<HitterModel> getHitters() {
        return hitterService.HitterData();
    }
}
