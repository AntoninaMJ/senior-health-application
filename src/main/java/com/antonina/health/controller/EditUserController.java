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
        EditUserForm editUserForm = new EditUserForm();
        editUserForm.setFirstName(userService.getLoggedUser().getFirstName());
        editUserForm.setLastName(userService.getLoggedUser().getLastName());
        editUserForm.setBirthDate(userService.getLoggedUser().getBirthDate());
        editUserForm.setGender(userService.getLoggedUser().getGender());

        model.addAttribute("editUserForm", editUserForm);
        return "editUser";
    }

    @PostMapping
    public String doEdit(@Validated @ModelAttribute EditUserForm editUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        User user = userService.getLoggedUser();
        user.setFirstName(editUserForm.getFirstName());
        user.setLastName(editUserForm.getLastName());
        user.setBirthDate(editUserForm.getBirthDate());
        user.setGender(editUserForm.getGender());
        userRepository.save(user);
        return "redirect:/settings";
    }
}
