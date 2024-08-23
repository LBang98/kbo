package com.example.kbo.controller.player;

import com.example.kbo.data.model.TeamRankingModel;
import com.example.kbo.data.service.TeamRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamRankingController {
    @Autowired
    private TeamRankingService teamRankingService;

    @GetMapping("/teamranking")
    public List<TeamRankingModel> getRankings() {
        return teamRankingService.scrapeRank();
    }
}
