package com.antonina.health.service;

import com.antonina.health.domain.Result;
import com.antonina.health.form.ResultForm;
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

    public void insertResults(ResultForm resultForm) {
        Result result = new Result();
        result.setUser(userService.getLoggedUser());
        result.setDateTime(LocalDateTime.now());
        result.setPressureDia(resultForm.getPressureDia());
        result.setPressureSys(resultForm.getPressureSys());
        result.setTemperature(resultForm.getTemperature());
        result.setMood(resultForm.getMood());
        repository.save(result);
    }
}
