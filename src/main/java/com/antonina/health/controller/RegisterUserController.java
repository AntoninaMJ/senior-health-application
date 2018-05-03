package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.form.RegisterUserForm;
import com.antonina.health.repository.UserRepository;
import com.antonina.health.util.PasswordUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
@RequestMapping("/register")
public class RegisterUserController {

    private final UserRepository userRepository;
    private final JavaMailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserController(UserRepository userRepository, JavaMailSender emailSender, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("registerUserForm", new RegisterUserForm());
        return "register";
    }

    @PostMapping
    public String doRegister(@Validated @ModelAttribute RegisterUserForm registerUserForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = userRepository.findByEmailAndActiveTrue(registerUserForm.getEmail());

        if (user != null) {
            return setError(model, "User with given email already exists");
        }

        user = new User();
        user.setEmail(registerUserForm.getEmail());
        user.setFirstName(registerUserForm.getFirstName());
        user.setLastName(registerUserForm.getLastName());
        user.setBirthDate(registerUserForm.getBirthDate());
        user.setGender(registerUserForm.getGender());
        user.setNotifyHour(registerUserForm.getNotifyHour());
        user.setActive(true);

        String newPassword = PasswordUtil.generatePassword();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Senior Health - password");
        message.setText("Hi! Your password: " + newPassword);
        emailSender.send(message);

        return "redirect:/login?register=true";
    }

    private String setError(Model model, String message) {
        model.addAttribute("error", message);
        return "register";
    }
}