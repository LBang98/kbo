package com.example.kbo.security.oauth;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {

    @GetMapping("/login/oauth2/code/kakao")
    public String kakaoLogin(OAuth2AuthenticationToken authentication, Model model) {
        // 카카오 로그인 후 처리 로직
        model.addAttribute("name", authentication.getPrincipal().getAttribute("nickname"));

        // 프론트엔드로 리다이렉트
        System.out.println(model);
        return "redirect:http://localhost:3000?name=" + model.getAttribute("name");
    }

    @GetMapping("/login/oauth2/code/naver")
    public String naverLogin(OAuth2AuthenticationToken authentication, Model model) {
        // 네이버 로그인 후 처리 로직
        model.addAttribute("name", authentication.getPrincipal().getAttribute("name"));

        System.out.println(model);
        // 프론트엔드로 리다이렉트
        return "redirect:http://localhost:3000?name=" + model.getAttribute("name");
    }
}
