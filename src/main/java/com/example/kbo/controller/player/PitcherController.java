package com.example.kbo.controller.player;

import com.example.kbo.data.model.PitcherModel;
import com.example.kbo.data.service.PitcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PitcherController {


    @Autowired
    private PitcherService pitcherService;

    @GetMapping("/pitcher")
    public List<PitcherModel> getPitcherData() {

        return pitcherService.PitcherData();
    }



}
