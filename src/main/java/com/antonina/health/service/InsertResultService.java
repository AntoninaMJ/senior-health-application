package com.antonina.health.service;

import com.antonina.health.domain.Result;
import com.antonina.health.form.InsertResultForm;
import com.antonina.health.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InsertResultService {

    private final ResultRepository repository;
    private final UserService userService;

    public InsertResultService(ResultRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void insertResults(InsertResultForm insertResultForm) {
        Result result = new Result();
        result.setUser(userService.getLoggedUser());
        result.setDateTime(LocalDateTime.now());
        result.setPressureDia(insertResultForm.getPressureDia());
        result.setPressureSys(insertResultForm.getPressureSys());
        result.setTemperature(insertResultForm.getTemperature());
        result.setMood(insertResultForm.getMood());
        repository.save(result); // insert into users(id, firstname, lastname, birthdate, gender) values(user.getId(), ....
    }
}
