package com.antonina.health.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "senior-health")
public class ApplicationConfigProperties {

    private int minPressureSys;
    private int maxPressureSys;
    private int minPressureDia;
    private int maxPressureDia;
    private float optTemperature;
    private int optMood;

    public int getMinPressureSys() {
        return minPressureSys;
    }

    public void setMinPressureSys(int minPressureSys) {
        this.minPressureSys = minPressureSys;
    }

    public int getMaxPressureSys() {
        return maxPressureSys;
    }

    public void setMaxPressureSys(int maxPressureSys) {
        this.maxPressureSys = maxPressureSys;
    }

    public int getMinPressureDia() {
        return minPressureDia;
    }

    public void setMinPressureDia(int minPressureDia) {
        this.minPressureDia = minPressureDia;
    }

    public int getMaxPressureDia() {
        return maxPressureDia;
    }

    public void setMaxPressureDia(int maxPressureDia) {
        this.maxPressureDia = maxPressureDia;
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