package com.cdgeekcamp.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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

        return "index";
    }
}
