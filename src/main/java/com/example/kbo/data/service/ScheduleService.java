package com.example.kbo.data.service;

import com.example.kbo.data.model.ScheduleModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    public List<ScheduleModel> getMatches() {
        List<ScheduleModel> matches = new ArrayList<>();
        try {
            String url = "https://sports.naver.com/kbaseball/schedule/index?date=2024-08-23";
            Document document = Jsoup.connect(url).get();


            for (Element matchBox : document.select("li.MatchBox_item_content__35GZf")) {
                ScheduleModel matchInfo = new ScheduleModel();

                String time = matchBox.select("li.MatchBox_time__nlEfd").text();
                matchInfo.setTime(time);

                String team1 = matchBox.select("li.MatchBoxTeamArea_team_3aB40").first().text();
                String team1Info = matchBox.select("li.MatchBoxTeamArea_item_11GUB").first().text();
                matchInfo.setTeam1(team1);
                matchInfo.setTeam1Info(team1Info);

                String team2 = matchBox.select("li.MatchBoxTeamArea_team_3aB40").last().text();
                String team2Info = matchBox.select("li.MatchBoxTeamArea_item_11GUB").last().text();
                matchInfo.setTeam2(team2);
                matchInfo.setTeam2Info(team2Info);

                matches.add(matchInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(matches);
        return matches;
    }
}
