package com.antonina.health.controller;

import com.antonina.health.domain.User;
import com.antonina.health.form.ForgotPasswordForm;
import com.antonina.health.repository.UserRepository;
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

import java.util.Random;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private final UserRepository userRepository;
    private final JavaMailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    public ForgotPasswordController(UserRepository userRepository, JavaMailSender emailSender, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping
    public String sendEmail(@Validated @ModelAttribute ForgotPasswordForm forgotPasswordForm, BindingResult bindingResult, Model model) {
        User user = userRepository.findByEmailAndActiveTrue(forgotPasswordForm.getEmail());

        if (bindingResult.hasErrors()) {
            return "/forgotPassword";
        }

        if (user == null) {
            model.addAttribute("error", "User with given email doesn't exist");
            return "/forgotPassword";
        }

        String newPassword = alphaNumericString(8);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Senior Health - new password");
        message.setText("Hi! New password: " + newPassword);

        emailSender.send(message);

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        return "redirect:/login?forgotPassword=true";
    }

    private String alphaNumericString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

}
