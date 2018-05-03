package com.antonina.health.controller;

import com.antonina.health.repository.ResultRepository;
import com.antonina.health.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/showChart")
public class ShowChartController {

    private final ResultRepository resultRepository;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    public ShowChartController(ResultRepository resultRepository, ObjectMapper objectMapper, UserService userService) {
        this.resultRepository = resultRepository;
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @GetMapping
    public String showChart(@RequestParam(value = "type", defaultValue = "temperature") String type, Model model) throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(resultRepository.findByUserIdOrderByDateTime(userService.getLoggedUser().getId()));

        model.addAttribute("type", type);
        model.addAttribute("results", jsonValue);

        return "showChart";
    }
}

