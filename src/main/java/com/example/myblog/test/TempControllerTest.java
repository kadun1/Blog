package com.example.myblog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    // http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome(){
        System.out.println("TempHome");
        //파일리턴 기본경로 : src/main/resources/static
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg(){
        return "/a.jpg";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp(){
        return "test";
    }
}
