package com.example.kbo.data.service;

import com.example.kbo.data.model.PitcherModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PitcherService {

    private static final Map<String, String> TEAM_MAP = new HashMap<>();

    static {
        TEAM_MAP.put("2002", "KIA");
        TEAM_MAP.put("1001", "삼성");
        TEAM_MAP.put("3001", "롯데");
        TEAM_MAP.put("6002", "두산");
        TEAM_MAP.put("11001", "NC");
        TEAM_MAP.put("7002", "한화");
        TEAM_MAP.put("9002", "SSG");
        TEAM_MAP.put("12001", "KT");
        TEAM_MAP.put("5002", "LG");
        TEAM_MAP.put("10001", "키움");
    }

    public List<PitcherModel> PitcherData() {
        String url = "https://statiz.sporki.com/stats/?m=main&m2=pitching";
        List<PitcherModel> pitcherPlayers = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Element tableBody = document.select("div.table_type01 table tbody").first();
            Elements rows = tableBody.select("tr");

            for (Element row : rows) {
                Elements columns = row.select("td");
                if (columns.size() > 0) {
                    PitcherModel pitcherPlayer = new PitcherModel();

                    pitcherPlayer.setRank(columns.get(0).text());
                    pitcherPlayer.setName(columns.get(1).text());

                    // 팀 정보 추출 및 변환
                    String teamHtml = columns.get(2).html();
                    Document teamDoc = Jsoup.parse(teamHtml);
                    Elements imgElements = teamDoc.select("img");
                    String teamSrc = imgElements.attr("src");

                    // 팀 코드 변환
                    String teamCode = teamSrc.split("/")[5].split("\\.")[0];
                    String teamName = getTeamName(teamCode);

                    pitcherPlayer.setTeam(teamName);

                    pitcherPlayer.setG(columns.get(3).text());
                    pitcherPlayer.setWar(columns.get(4).text());
                    pitcherPlayer.setGs(columns.get(5).text());
                    pitcherPlayer.setGr(columns.get(6).text());
                    pitcherPlayer.setGf(columns.get(7).text());
                    pitcherPlayer.setCg(columns.get(8).text());
                    pitcherPlayer.setSho(columns.get(9).text());
                    pitcherPlayer.setW(columns.get(10).text());
                    pitcherPlayer.setL(columns.get(11).text());
                    pitcherPlayer.setSv(columns.get(12).text());
                    pitcherPlayer.setHd(columns.get(13).text());
                    pitcherPlayer.setIp(columns.get(14).text());
                    pitcherPlayer.setEr(columns.get(15).text());
                    pitcherPlayer.setR(columns.get(16).text());
                    pitcherPlayer.setRra(columns.get(17).text());
                    pitcherPlayer.setTbf(columns.get(18).text());
                    pitcherPlayer.setH(columns.get(19).text());
                    pitcherPlayer.setHr(columns.get(20).text());
                    pitcherPlayer.setBb(columns.get(21).text());
                    pitcherPlayer.setSo(columns.get(22).text());
                    pitcherPlayer.setRoe(columns.get(23).text());
                    pitcherPlayer.setBk(columns.get(24).text());
                    pitcherPlayer.setWp(columns.get(25).text());
                    pitcherPlayer.setEra(columns.get(26).text());

                    pitcherPlayers.add(pitcherPlayer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pitcherPlayers;
    }

    private String getTeamName(String teamCode) {
        return TEAM_MAP.getOrDefault(teamCode, "Unknown");
    }
}
