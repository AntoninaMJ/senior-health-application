package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.repository.ResultRepository;
import com.antonina.health.repository.UserRepository;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private final UserService userService;
    private final UserRepository userRepository;

    public SettingsController(ResultRepository repository, UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String settings(Model model) {
        User loggedUser = userService.getLoggedUser();
        User user = userRepository.findById(loggedUser.getId()).get();
        model.addAttribute("results", user);
        return "settings";
    }

}
