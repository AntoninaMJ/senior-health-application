package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.form.RegisterUserForm;
import com.antonina.health.service.RegisterUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    private final RegisterUserService registerUserService;

    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("registerUserForm", new RegisterUserForm());
        return "register";
    }

    @PostMapping
    public String doRegister(@Validated @ModelAttribute RegisterUserForm registerUserForm, BindingResult bindingResult) {
        User user = registerUserService.getUserRepository().findByEmail(registerUserForm.getEmail());
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (user == null) {
            if (registerUserForm.getPassword().equals(registerUserForm.getPasswordRepeat())) {
                registerUserService.registerUser(registerUserForm);
                return "redirect:/login";
            }
            return "register";
        } else {
            user.setActive(true);
            registerUserService.getUserRepository().save(user);

            return "redirect:/login";
        }
    }
}