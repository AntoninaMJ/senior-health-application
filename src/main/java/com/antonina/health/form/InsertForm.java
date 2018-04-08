package com.antonina.health.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InsertForm {

    @NotNull
    @Max(200)
    @Min(80)
    private Integer pressureSys;
    @NotNull
    @Max(160)
    @Min(50)
    private Integer pressureDia;
    @NotNull
    @Max(42)
    @Min(34)
    private Float temperature;
    @NotNull
    @Max(5)
    @Min(1)
    private Integer mood;

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
