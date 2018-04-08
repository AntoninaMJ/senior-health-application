package com.antonina.health.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //info ze to jest baza danych
@Table(name = "results") //będzie tabela o nazwie
public class Result {

    @Id //@ - annotation, pokazuje co jest PK's
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private LocalDateTime dateTime;
    private Integer pressureSys;
    private Integer pressureDia;
    private Float temperature;
    private Integer mood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getPressureSys() {
        return pressureSys;
    }

    public void setPressureSys(Integer pressureSys) {
        this.pressureSys = pressureSys;
    }

    public Integer getPressureDia() {
        return pressureDia;
    }

    public void setPressureDia(Integer pressureDia) {
        this.pressureDia = pressureDia;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }
}
