package com.antonina.health.controller;

import com.antonina.health.config.ApplicationConfigProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    private final ApplicationConfigProperties configProperties;

    public HistoryController(ApplicationConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("optMood", configProperties.getOptMood());
        return "history";
    }
}