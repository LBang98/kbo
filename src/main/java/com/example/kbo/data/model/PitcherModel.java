package com.example.kbo.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitcherModel {
    private String rank;
    private String name;
    private String team;
    private String g; // 추가된 필드
    private String war;
    private String gs;
    private String gr;
    private String gf;
    private String cg;
    private String sho;
    private String w;
    private String l;
    private String sv;
    private String hd;
    private String ip;
    private String er;
    private String r;
    private String rra;
    private String tbf;
    private String h;
    private String b2;
    private String b3;
    private String hr;
    private String bb;
    private String hp;
    private String ib;
    private String so;
    private String roe;
    private String bk;
    private String wp;
    private String era;

    // Getters and setters

    @Override
    public String toString() {
        return "Player{" +
                "rank='" + rank + '\'' +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", g='" + g + '\'' +
                ", war='" + war + '\'' +
                ", gs='" + gs + '\'' +
                ", gr='" + gr + '\'' +
                ", gf='" + gf + '\'' +
                ", cg='" + cg + '\'' +
                ", sho='" + sho + '\'' +
                ", w='" + w + '\'' +
                ", l='" + l + '\'' +
                ", sv='" + sv + '\'' +
                ", hd='" + hd + '\'' +
                ", ip='" + ip + '\'' +
                ", er='" + er + '\'' +
                ", r='" + r + '\'' +
                ", rra='" + rra + '\'' +
                ", tbf='" + tbf + '\'' +
                ", h='" + h + '\'' +
                ", hr='" + hr + '\'' +
                ", bb='" + bb + '\'' +
                ", so='" + so + '\'' +
                ", roe='" + roe + '\'' +
                ", bk='" + bk + '\'' +
                ", wp='" + wp + '\'' +
                ", era='" + era + '\'' +
                '}';
    }
}
