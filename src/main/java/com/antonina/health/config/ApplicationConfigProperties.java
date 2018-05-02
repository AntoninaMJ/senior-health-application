package com.antonina.health.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "senior-health")
public class ApplicationConfigProperties {

    private int minOptPressureSys;
    private int maxOptPressureSys;
    private int minOptPressureDia;
    private int maxOptPressureDia;
    private float optTemperature;
    private int optMood;

    public int getMinOptPressureSys() {
        return minOptPressureSys;
    }

    public void setMinOptPressureSys(int minOptPressureSys) {
        this.minOptPressureSys = minOptPressureSys;
    }

    public int getMaxOptPressureSys() {
        return maxOptPressureSys;
    }

    public void setMaxOptPressureSys(int maxOptPressureSys) {
        this.maxOptPressureSys = maxOptPressureSys;
    }

    public int getMinOptPressureDia() {
        return minOptPressureDia;
    }

    public void setMinOptPressureDia(int minOptPressureDia) {
        this.minOptPressureDia = minOptPressureDia;
    }

    public int getMaxOptPressureDia() {
        return maxOptPressureDia;
    }

    public void setMaxOptPressureDia(int maxOptPressureDia) {
        this.maxOptPressureDia = maxOptPressureDia;
    }

    public float getOptTemperature() {
        return optTemperature;
    }

    public void setOptTemperature(float optTemperature) {
        this.optTemperature = optTemperature;
    }

    public int getOptMood() {
        return optMood;
    }

    public void setOptMood(int optMood) {
        this.optMood = optMood;
    }
}