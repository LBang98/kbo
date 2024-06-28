package com.example.kbo.data.service;

import com.example.kbo.data.model.PitcherModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PitcherService {

    public List<PitcherModel> PitcherData() {
        String url = "https://statiz.sporki.com/stats/?m=main&m2=pitching";
        List<PitcherModel> Pitcherplayers = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Element tableBody = document.select("div.table_type01 table tbody").first();
            Elements rows = tableBody.select("tr");

            for (Element row : rows) {
                Elements columns = row.select("td");
                if (columns.size() > 0) {
                    PitcherModel Pitcherplayer = new PitcherModel();

                    Pitcherplayer.setRank(columns.get(0).text());
                    Pitcherplayer.setName(columns.get(1).text());
                    Pitcherplayer.setTeam(columns.get(2).text());
                    Pitcherplayer.setG(columns.get(3).text());
                    Pitcherplayer.setWar(columns.get(4).text());
                    Pitcherplayer.setGs(columns.get(5).text());
                    Pitcherplayer.setGr(columns.get(6).text());
                    Pitcherplayer.setGf(columns.get(7).text());
                    Pitcherplayer.setCg(columns.get(8).text());
                    Pitcherplayer.setSho(columns.get(9).text());
                    Pitcherplayer.setW(columns.get(10).text());
                    Pitcherplayer.setL(columns.get(11).text());
                    Pitcherplayer.setSv(columns.get(12).text());
                    Pitcherplayer.setHd(columns.get(13).text());
                    Pitcherplayer.setIp(columns.get(14).text());
                    Pitcherplayer.setEr(columns.get(15).text());
                    Pitcherplayer.setR(columns.get(16).text());
                    Pitcherplayer.setRra(columns.get(17).text());
                    Pitcherplayer.setTbf(columns.get(18).text());
                    Pitcherplayer.setH(columns.get(19).text());
                    Pitcherplayer.setHr(columns.get(20).text());
                    Pitcherplayer.setBb(columns.get(21).text());
                    Pitcherplayer.setSo(columns.get(22).text());
                    Pitcherplayer.setRoe(columns.get(23).text());
                    Pitcherplayer.setBk(columns.get(24).text());
                    Pitcherplayer.setWp(columns.get(25).text());
                    Pitcherplayer.setEra(columns.get(26).text());

                    Pitcherplayers.add(Pitcherplayer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the URL: " + url);
        }

        return Pitcherplayers;
    }
}
