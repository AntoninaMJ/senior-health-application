package com.antonina.health.controller;


import com.antonina.health.form.InsertForm;
import com.antonina.health.service.InsertService;
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
public class InsertController {

    private final InsertService insertService;

    public InsertController(InsertService insertService) {
        this.insertService = insertService;
    }

    @GetMapping
    public String insert(Model model) {
        model.addAttribute("insertForm", new InsertForm());
        return "insert";
    }

    @PostMapping
    public String doInsert(@Validated @ModelAttribute InsertForm insertForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "insert";
        }
        insertService.insertResults(insertForm);
        return "history";
    }
}
