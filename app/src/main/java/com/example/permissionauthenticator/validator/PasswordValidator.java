package com.example.permissionauthenticator.validator;
import java.util.regex.Pattern;

public class PasswordValidator extends Rule {
    private Pattern passwordRegex;
    private String passwordInput;

    public PasswordValidator() {
        passwordRegex = Pattern.compile("[/d/w]{8,}");
    }

    public void setPasswordInput(String passwordInput){
        this.passwordInput = passwordInput;
    }

    @Override
    public boolean validate() {
        return passwordRegex.matcher(passwordInput).find();
    }
}
