package com.example.kbo.controller.user;

import com.example.kbo.data.dto.UserDto;
import com.example.kbo.data.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import com.example.kbo.naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserFormController {

    @Autowired
    private UserService userService;

    private String bucketName = "bitcamp-bh-98";
    private String folderName = "football";

    @Autowired
    private NcpObjectStorageService storageService;


    @ResponseBody
    @GetMapping("/user/idcheck")
    public Map<String, Integer> getIdCheck(@RequestParam("searchid") String searchid) {
        Map<String, Integer> map = new HashMap<>();
        int count = userService.getIdCheckCount(searchid);
        map.put("count", count);
        return map;
    }

    @PostMapping("/user/insert")
    public String saveData(
            @ModelAttribute UserDto dto,
            @RequestParam("myfile") MultipartFile myfile,
            HttpServletRequest request) {
        String profile = storageService.uploadFile(bucketName, folderName, myfile);
        dto.setProfile(profile);

        userService.insertUser(dto);

        return "redirect:/";
    }

    @GetMapping("/user/find")
    public String findId(){

        return "/";
    }

}
