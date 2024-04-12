package com.cdgeekcamp.shijianxing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Controller
public class HomeController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String login_time = (String) session.getAttribute("LOGIN_TIME");
        model.addAttribute("loginTime", login_time);

        String photo = (String) session.getAttribute("PHOTO");
        model.addAttribute("photo", photo);

        String user_name = (String) session.getAttribute("USER_NAME");
        model.addAttribute("user_name", user_name);

        return "index";
    }
}
