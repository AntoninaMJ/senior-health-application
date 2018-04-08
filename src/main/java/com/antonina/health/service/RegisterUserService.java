package com.antonina.health.service;

import com.antonina.health.domain.User;
import com.antonina.health.form.RegisterUserForm;
import com.antonina.health.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterUserForm registerUserForm) {
        User user = new User();
        user.setEmail(registerUserForm.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserForm.getPassword()));
        user.setFirstName(registerUserForm.getFirstName());
        user.setLastName(registerUserForm.getLastName());

        repository.save(user); // insert into users(id, firstname, lastname, birthdate, gender) values(user.getId(), ....
    }
}
