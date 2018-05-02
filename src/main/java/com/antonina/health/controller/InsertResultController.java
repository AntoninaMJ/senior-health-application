package com.antonina.health.controller;


import com.antonina.health.form.ResultForm;
import com.antonina.health.service.InsertResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insert")
public class InsertResultController {

    private final InsertResultService insertResultService;

    public InsertResultController(InsertResultService insertResultService) {
        this.insertResultService = insertResultService;
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
        insertResultService.insertResults(resultForm);
        return "redirect:/history";
    }
}