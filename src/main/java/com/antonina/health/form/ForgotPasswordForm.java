package com.antonina.health.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ForgotPasswordForm {

    @Email
    @NotEmpty
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}