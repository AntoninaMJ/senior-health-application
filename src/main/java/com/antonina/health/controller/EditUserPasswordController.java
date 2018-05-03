package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.form.EditUserPasswordForm;
import com.antonina.health.repository.UserRepository;
import com.antonina.health.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editUserPassword")
public class EditUserPasswordController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public EditUserPasswordController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String edit(Model model, EditUserPasswordForm editUserPasswordForm) {
        model.addAttribute(editUserPasswordForm);
        return "editUserPassword";
    }

    @PostMapping
    public String doEdit(@Validated @ModelAttribute EditUserPasswordForm editUserPasswordForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editUserPassword";
        }

        String passwordOld = editUserPasswordForm.getPasswordOld();
        String passwordEncoded = userService.getLoggedUser().getPassword();

        if (!passwordEncoder.matches(passwordOld, passwordEncoded)) {
            model.addAttribute("error", "Wrong actual password.");
            return "editUserPassword";
        }

        if (!editUserPasswordForm.getPassword().equals(editUserPasswordForm.getPasswordRepeat())) {
            model.addAttribute("error", "Repeat password should be the same as password.");
            return "editUserPassword";
        }

        User user = userService.getLoggedUser();
        user.setPassword(passwordEncoder.encode(editUserPasswordForm.getPassword()));
        userRepository.save(user);

        return "redirect:/settings";
    }
}
