package com.antonina.health.service;

import com.antonina.health.domain.User;
import com.antonina.health.form.RegisterForm;
import com.antonina.health.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterForm registerForm) {
        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        user.setFirstName(registerForm.getFirstName());
        user.setLastName(registerForm.getLastName());

        repository.save(user); // insert into users(id, firstname, lastname, birthdate, gender) values(user.getId(), ....
    }
}
