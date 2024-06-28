package com.example.kbo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int num;
    private String userid;
    private String userpw;
    private String name;
    private String nickname;
    private String profile;
    private String hp;
    private String email;
    private Timestamp joinday;
}
