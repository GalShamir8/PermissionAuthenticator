package com.example.permissionauthenticator.validator;
import android.util.Log;

import java.util.regex.Pattern;

public class PasswordValidator extends Rule {
    private final Pattern passwordRegex = Pattern.compile("[\\d\\w]{8,}");
    private String passwordInput;

    public PasswordValidator() { }

    public void setPasswordInput(String passwordInput){
        this.passwordInput = passwordInput;
    }

    @Override
    public boolean validate() {
        return passwordRegex.matcher(passwordInput).find();
    }
}
