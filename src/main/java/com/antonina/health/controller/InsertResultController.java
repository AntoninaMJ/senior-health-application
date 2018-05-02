package com.antonina.health.controller;


import com.antonina.health.domain.Result;
import com.antonina.health.form.ResultForm;
import com.antonina.health.repository.ResultRepository;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/insert")
public class InsertResultController {

    private final ResultRepository repository;
    private final UserService userService;

    public InsertResultController(ResultRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping
    public String insert(Model model) {
        model.addAttribute("resultForm", new ResultForm());
        return "insert";
    }

    @PostMapping
    public String doInsert(@Validated @ModelAttribute ResultForm resultForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "insert";
        }
        insertResult(resultForm);
        return "redirect:/history";
    }

    private void insertResult(ResultForm resultForm) {
        Result result = new Result();
        result.setUser(userService.getLoggedUser());
        result.setDateTime(LocalDateTime.now());
        result.setPressureDia(resultForm.getPressureDia());
        result.setPressureSys(resultForm.getPressureSys());
        result.setTemperature(resultForm.getTemperature());
        result.setMood(resultForm.getMood());
        repository.save(result);
    }
}