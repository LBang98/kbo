package com.example.kbo.data.service;

import com.example.kbo.data.dto.UserDto;
import com.example.kbo.mapperInter.UserMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapperInter userMapperInter;

    public int getTotalCount() {

        return userMapperInter.getTotalCount();
    }

    public int getIdCheckCount(String searchid) {

        return userMapperInter.getIdCheckCount(searchid);
    }

    public void insertUser(UserDto dto) {
        userMapperInter.insertUser(dto);
    }

    public List<UserDto> getAllUsers() {
        return userMapperInter.getAllUsers();
    }

    public UserDto getData(int num) {
        return userMapperInter.getData(num);
    }

    public UserDto getDataById(String id) {
        return userMapperInter.getDataById(id);
    }

    public void updatePhoto(int num, String photo) {
        Map<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("profile", photo);

        userMapperInter.updatePhoto(map);
    }

    public void updateUser(UserDto dto) {
        userMapperInter.updateUser(dto);
    }

    public boolean isEqualPassCheck(int num, String pw) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num", num);
        map.put("pw", pw);
        int n = userMapperInter.isEqualPassCheck(map);
        return n == 1 ? true : false;
    }

///*
//    public void deleteUser(int num) {
//        userMapperInter.deleteUser(num);
//    }
//*/

    public boolean isLoginCheck(String id, String pw) {
        return userMapperInter.isloginCheck(id, pw) == 1 ? true : false;
    }


    public int getNum(String id){
        return userMapperInter.getNum(id);
    }
}