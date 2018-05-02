package com.antonina.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    private String login(@RequestParam(required = false) String error,
                         @RequestParam(required = false) String forgotPassword, Model model) {
        if (error != null) {
            model.addAttribute("error", "Wrong login or password");
        }

        if (forgotPassword != null) {
            model.addAttribute("success", "E-mail with new password has been sent");
        }

        return "login";
    }
}
