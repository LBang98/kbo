package com.example.kbo.controller.user;

import com.example.kbo.data.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    @Autowired
    public UserService userService;

    @GetMapping("/user/form")
    public String form() {
        return "users/signup";
    }


    @PostMapping("/user/login")
    public String isLogin(
            @RequestParam String email,
            @RequestParam String userpw,
            HttpSession session,
            Model model
    ) {
        // 로그인 상태 확인
        boolean loginStatus = userService.isLoginCheck(email, userpw);
        if (loginStatus) {
            // 아이디와 비번이 맞은 경우
            // 로그인 성공시 세션에 저장
            session.setAttribute("loginok", "yes");
            session.setAttribute("loginid", email);

            // 리다이렉트
            return "redirect:/hitter";
        } else {
            // 아이디와 비번이 틀린 경우
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "users/login"; // 로그인 페이지로 다시 이동
        }
    }

    // 로그아웃시 호출
    @PostMapping("/user/logout")
    public String memberLogout(HttpSession session) {
        session.removeAttribute("loginok");
        session.invalidate();
        return "redirect:/";
    }
}
