package com.antonina.health.form;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class InsertResultForm {

    @NotNull
    @Max(200)
    @Min(80)
    private Integer pressureSys;
    @NotNull
    @Max(160)
    @Min(50)
    private Integer pressureDia;
    @NotNull
    @DecimalMax("42.0")
    @DecimalMin("34.0")
    private BigDecimal temperature;
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

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }
}
