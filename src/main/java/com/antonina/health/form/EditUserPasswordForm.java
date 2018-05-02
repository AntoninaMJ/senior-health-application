package com.antonina.health.form;

import javax.validation.constraints.NotEmpty;

public class EditUserPasswordForm {

    @NotEmpty
    private String passwordOld;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordRepeat;

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
