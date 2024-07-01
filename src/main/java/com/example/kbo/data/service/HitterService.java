package com.example.kbo.data.service;

import com.example.kbo.data.model.HitterModel;
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
public class HitterService {

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

    public List<HitterModel> HitterData() {
        String url = "https://statiz.sporki.com/stats/?m=main&m2=batting";
        List<HitterModel> hitters = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Element tableBody = document.select("div.table_type01 table tbody").first();
            Elements rows = tableBody.select("tr");

            for (Element row : rows) {
                Elements columns = row.select("td");
                if (columns.size() > 0) {
                    HitterModel batter = new HitterModel();
                    batter.setRank(columns.get(0).text());
                    batter.setName(columns.get(1).text());

                    // 팀 정보 추출 및 변환
                    String teamHtml = columns.get(2).html();
                    Document teamDoc = Jsoup.parse(teamHtml);
                    Elements imgElements = teamDoc.select("img");
                    String teamSrc = imgElements.attr("src");

                    // 팀 코드 변환
                    String teamCode = teamSrc.split("/")[5].split("\\.")[0];
                    String teamName = getTeamName(teamCode);

                    batter.setTeam(teamName);

                    batter.setWar(columns.get(3).text());
                    batter.setOwar(columns.get(4).text());
                    batter.setDwar(columns.get(5).text());
                    batter.setG(columns.get(6).text());
                    batter.setPa(columns.get(7).text());
                    batter.setEpa(columns.get(8).text());
                    batter.setAb(columns.get(9).text());
                    batter.setR(columns.get(10).text());
                    batter.setH(columns.get(11).text());
                    batter.setB2(columns.get(12).text());
                    batter.setB3(columns.get(13).text());
                    batter.setHr(columns.get(14).text());
                    batter.setTb(columns.get(15).text());
                    batter.setRbi(columns.get(16).text());
                    batter.setSb(columns.get(17).text());
                    batter.setCs(columns.get(18).text());
                    batter.setBb(columns.get(19).text());
                    batter.setHp(columns.get(20).text());
                    batter.setIb(columns.get(21).text());
                    batter.setSo(columns.get(22).text());
                    batter.setGdp(columns.get(23).text());
                    batter.setSh(columns.get(24).text());
                    batter.setSf(columns.get(25).text());
                    batter.setAvg(columns.get(26).text());
                    batter.setObp(columns.get(27).text());
                    batter.setSlg(columns.get(28).text());
                    batter.setOps(columns.get(29).text());
                    batter.setRe_pa(columns.get(30).text());

                    hitters.add(batter);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hitters;
    }

    private String getTeamName(String teamCode) {
        return TEAM_MAP.getOrDefault(teamCode, "Unknown");
    }
}
