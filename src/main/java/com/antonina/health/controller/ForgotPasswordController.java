package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
    UserService userService;

    public ForgotPasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping
    public String sendEmail(@Validated @ModelAttribute String email, BindingResult bindingResult) {
        User user = userService.getRepository().findByEmail(email);

        if (bindingResult.hasErrors()) {
            return "/";
        }
        if (user == null) {
            return "/";
        } else {
            user.setActive(true);
            userService.getRepository().save(user);

            return "login";
        }
    }

}
