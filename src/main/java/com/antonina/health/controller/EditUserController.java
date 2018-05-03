package com.antonina.health.controller;


import com.antonina.health.domain.User;
import com.antonina.health.form.EditUserForm;
import com.antonina.health.repository.UserRepository;
import com.antonina.health.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editUser")
public class EditUserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public EditUserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String edit(Model model) {
        User loggedUser = userService.getLoggedUser();
        User user = userRepository.findById(loggedUser.getId()).get();

        EditUserForm editUserForm = new EditUserForm();
        editUserForm.setFirstName(user.getFirstName());
        editUserForm.setLastName(user.getLastName());
        editUserForm.setBirthDate(user.getBirthDate());
        editUserForm.setGender(user.getGender());
        editUserForm.setNotifyHour(user.getNotifyHour());

        model.addAttribute(editUserForm);
        return "editUser";
    }

    @PostMapping
    public String doEdit(@Validated @ModelAttribute EditUserForm editUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }

        User loggedUser = userService.getLoggedUser();
        User user = userRepository.findById(loggedUser.getId()).get();

        user.setFirstName(editUserForm.getFirstName());
        user.setLastName(editUserForm.getLastName());
        user.setBirthDate(editUserForm.getBirthDate());
        user.setGender(editUserForm.getGender());
        user.setNotifyHour(editUserForm.getNotifyHour());
        userRepository.save(user);

        return "redirect:/settings";
    }
}
