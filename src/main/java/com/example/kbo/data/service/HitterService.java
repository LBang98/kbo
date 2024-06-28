package com.example.kbo.data.service;

import com.example.kbo.data.model.HitterModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HitterService {

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
                    batter.setTeam(columns.get(2).text());
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
            System.out.println("Failed to connect to the URL: " + url);
        }

        return hitters;
    }
}
