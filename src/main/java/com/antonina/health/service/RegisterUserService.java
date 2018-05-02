package com.antonina.health.service;

import com.antonina.health.domain.User;
import com.antonina.health.form.RegisterUserForm;
import com.antonina.health.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void registerUser(RegisterUserForm registerUserForm) {
        User user = new User();
        user.setEmail(registerUserForm.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserForm.getPassword()));
        user.setFirstName(registerUserForm.getFirstName());
        user.setLastName(registerUserForm.getLastName());
        user.setBirthDate(registerUserForm.getBirthDate());
        user.setGender(registerUserForm.getGender());
        user.setActive(true);

        userRepository.save(user);
    }
}
