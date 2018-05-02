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
    public String doEdit(@Validated @ModelAttribute EditUserPasswordForm editUserPasswordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUserPassword";
        }
        if (editUserPasswordForm.getPassword().equals(editUserPasswordForm.getPasswordRepeat()) &&
                passwordEncoder.encode(editUserPasswordForm.getPasswordOld()).equals(userService.getLoggedUser().getPassword())) {
            User user = userService.getLoggedUser();
            user.setPassword(passwordEncoder.encode(editUserPasswordForm.getPassword()));
            userRepository.save(user);
            return "redirect:/login";
        }
        return "editUserPassword";
    }
}
