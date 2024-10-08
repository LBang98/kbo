package com.example.kbo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /* 프론트 서버와의 CORS 이슈를 해결하기 위한 메소드입니다.*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                // 내가 직접 만든 귀여운 헤더 이름을 받을 수 있도록 명시해줍시다
                .exposedHeaders("Authorization", "Set-Cookie")
                .allowedMethods("*")
                .allowCredentials(true);

        // JWT 인증이 필요 없는 엔드포인트에 대한 CORS 설정
        registry.addMapping("/hitter")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET");
        registry.addMapping("/pitcher")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET");
        registry.addMapping("/schedule")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET");
        registry.addMapping("/teamranking")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET");
    }
}