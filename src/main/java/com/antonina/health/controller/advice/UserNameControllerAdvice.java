package com.antonina.health.controller.advice;

import com.antonina.health.domain.User;
import com.antonina.health.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserNameControllerAdvice {

    private final UserService userService;

    public UserNameControllerAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        User loggedUser = userService.getLoggedUser();

        if (loggedUser != null) {
            String name = loggedUser.getFirstName() + " " + loggedUser.getLastName();
            model.addAttribute("name", name);
        }
    }
}
