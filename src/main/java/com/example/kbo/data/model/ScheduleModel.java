package com.example.kbo.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleModel {
    private String time;
    private String team1;
    private String team1Info;
    private String team2;
    private String team2Info;

    // Getters and Setters

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam1Info() {
        return team1Info;
    }

    public void setTeam1Info(String team1Info) {
        this.team1Info = team1Info;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam2Info() {
        return team2Info;
    }

    public void setTeam2Info(String team2Info) {
        this.team2Info = team2Info;
    }

}
