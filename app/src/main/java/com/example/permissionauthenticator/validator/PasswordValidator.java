package com.example.permissionauthenticator.validator;
import java.util.regex.Pattern;

public class PasswordValidator extends Rule {
    private Pattern passwordRegex;

    public PasswordValidator() {
        passwordRegex = Pattern.compile("[/d/w]{8,}");
    }

    @Override
    public boolean validate(Object... params) {
        return passwordRegex.matcher((String)(params[0])).find();
    }
}
