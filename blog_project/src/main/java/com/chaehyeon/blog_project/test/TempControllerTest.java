package com.chaehyeon.blog_project.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    // http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println(("tempHome()"));
        // 파일리턴 기본경로: /src/main/resources/static
        // 리터명: /home.html
        // 풀경로: /src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg() {
        return "/a.jpg";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        return "test";
    }
}
