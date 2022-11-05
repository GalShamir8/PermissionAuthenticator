package com.example.permissionauthenticator.validator;

import android.util.Log;

import java.util.regex.Pattern;

public class UsernameValidator extends Rule {
    private Pattern usernameRegex;
    private String usernameInput;

    public UsernameValidator() {
        usernameRegex = Pattern.compile("[\\w]{3,}");
    }

    public void setUsernameInput(String usernameInput){
        this.usernameInput = usernameInput;
    }
    @Override
    public boolean validate() {
        return usernameRegex.matcher(usernameInput).find();
    }
}
