package com.fundacioesplai.lectura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui") 
public class PageController {
    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // returns signup.html
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard"; // returns dashboard.html
    }
    
}
