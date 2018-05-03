package com.antonina.health.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EditUserPasswordForm {

    @NotEmpty
    private String passwordOld;
    @NotEmpty
    @Size(min = 5, max = 50)
    private String password;
    @NotEmpty
    @Size(min = 5, max = 50)
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
