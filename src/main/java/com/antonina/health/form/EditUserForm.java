package com.antonina.health.form;

import com.antonina.health.domain.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class EditUserForm {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Gender gender;
    @Min(0)
    @Max(23)
    private Integer notifyHour;

    public Integer getNotifyHour() {
        return notifyHour;
    }

    public void setNotifyHour(Integer notifyHour) {
        this.notifyHour = notifyHour;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
