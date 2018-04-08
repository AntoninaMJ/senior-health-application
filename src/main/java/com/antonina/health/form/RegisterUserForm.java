package com.antonina.health.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RegisterUserForm {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    //@NotEmpty
    //private String passwordRepeat;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    //@NotNull
    //private LocalDate birthDate;
    //@NotNull
    //private Gender gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
        public String getPasswordRepeat() {
            return passwordRepeat;
        }

        public void setPasswordRepeat(String passwordRepeat) {
            this.passwordRepeat = passwordRepeat;
        }
    */
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

    /*
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
    */
}