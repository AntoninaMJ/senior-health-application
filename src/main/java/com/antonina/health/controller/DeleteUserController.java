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
    private final UserRepository userRepository;

    public DeleteUserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String delete() {
        User user = userService.getLoggedUser();
        user.setActive(false);
        userRepository.save(user);
        return "redirect:/login";
    }
}
