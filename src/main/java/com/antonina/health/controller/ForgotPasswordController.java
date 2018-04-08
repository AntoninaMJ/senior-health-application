package com.antonina.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @GetMapping
    public String forgotPassword() {
        return "forgot-password";
    }

    @PostMapping
    public String sendEmail(@Validated @ModelAttribute String email, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/";
        }
        //znajdz email w bazie uzytkownkow, wyslij na niego email z haslem
        return "login";
    }

}
