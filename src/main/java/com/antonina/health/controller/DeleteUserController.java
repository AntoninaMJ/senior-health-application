package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.repository.UserRepository;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteUser")
public class DeleteUserController {
    private final UserService userService;

    public DeleteUserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @GetMapping
    public String delete() {
        User user = userService.getLoggedUser();
        user.setActive(false);
        userService.getRepository().save(user);
        return "redirect:/login";
    }
}
