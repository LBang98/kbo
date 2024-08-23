package com.example.kbo.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRankingModel {

    private String rank;     // 등수
    private String logo;     // 로고 (이미지)
    private String name;     // 팀명
    private String games;    // 경기 수
    private String wins;     // 승
    private String losses;   // 패
    private String draws;    // 무
    private String winRate;  // 승률
    private String streak;   // 연승
    private String recent;   // 최근 10경기

}
