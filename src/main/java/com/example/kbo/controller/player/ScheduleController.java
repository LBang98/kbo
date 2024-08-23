package com.example.kbo.controller.player;

import com.example.kbo.data.model.ScheduleModel;
import com.example.kbo.data.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<ScheduleModel> getAllGames() {

        return scheduleService.getMatches();
    }
}
