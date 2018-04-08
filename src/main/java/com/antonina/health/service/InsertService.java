package com.antonina.health.service;

import com.antonina.health.domain.Result;
import com.antonina.health.form.InsertForm;
import com.antonina.health.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InsertService {
    private final ResultRepository repository;

    public InsertService(ResultRepository repository) {
        this.repository = repository;
    }

    public void insertResults(InsertForm insertForm) {
        Result result = new Result();
        //result.setUserId(); - aktualny użytkownik
        result.setDateTime(LocalDateTime.now());
        result.setPressureDia(insertForm.getPressureDia());
        result.setPressureSys(insertForm.getPressureSys());
        result.setTemperature(insertForm.getTemperature());
        result.setMood(insertForm.getMood());
        repository.save(result); // insert into users(id, firstname, lastname, birthdate, gender) values(user.getId(), ....
    }
}
