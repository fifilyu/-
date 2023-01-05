package com.cdgeekcamp.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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

        String user_full_name = (String) session.getAttribute("USER_FULL_NAME");
        model.addAttribute("user_full_name", user_full_name);

        return "index";
    }
}
