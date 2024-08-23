package com.example.kbo.data.service;

import com.example.kbo.data.model.TeamRankingModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamRankingService {

    public List<TeamRankingModel> scrapeRank() {
        List<TeamRankingModel> teamDataList = new ArrayList<>();
        try {

            // KBO 리그 순위 가져오기
            Document doc = Jsoup.connect("https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo")
                    .userAgent(
                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
                    .get();

            // select를 이용해서 tr들을 불러오기
            Elements baseballTeams = doc.select("#regularTeamRecordList_table > tr");

            // tr들의 반복문 돌리기
            for (Element baseballTeam : baseballTeams) {
                Element rank = baseballTeam.select("th").first(); // 등 수
                Element title = baseballTeam.select("span:nth-child(2)").first(); // 팀 명
                Element match = baseballTeam.select("td:nth-child(3)").first(); // 경기 수
                Element victory = baseballTeam.select("td:nth-child(4)").first(); // 승
                Element defeat = baseballTeam.select("td:nth-child(5)").first(); // 패
                Element draw = baseballTeam.select("td:nth-child(6)").first(); // 무
                Element rate = baseballTeam.select("td:nth-child(7)").first(); // 승률
                Element winning = baseballTeam.select("td:nth-child(9)").first(); // 연승
                Element recent = baseballTeam.select("td:nth-child(12)").first(); // 최근 10경기


                if (title != null) {
                    String image = title.text();
                    TeamRankingModel teamData = new TeamRankingModel(rank.text(), image, title.text(), match.text(), victory.text(),
                            defeat.text(), draw.text(), rate.text(), winning.text(), recent.text());
                    teamDataList.add(teamData);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return teamDataList;
    }
}
