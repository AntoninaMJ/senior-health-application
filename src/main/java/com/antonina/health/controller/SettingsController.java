package com.antonina.health.controller;

import com.antonina.health.repository.ResultRepository;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private final UserService userService;

    public SettingsController(ResultRepository repository, UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String settings(Model model) {
        model.addAttribute("results", userService.getLoggedUser());
        return "settings";
    }

}
