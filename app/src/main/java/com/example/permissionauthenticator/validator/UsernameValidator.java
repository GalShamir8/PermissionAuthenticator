package com.example.permissionauthenticator.validator;

import java.util.regex.Pattern;

public class UsernameValidator extends Rule {
    private Pattern usernameRegex;

    public UsernameValidator() {
        usernameRegex = Pattern.compile("/w{3,}");
    }

    @Override
    public boolean validate(Object... params) {
        return usernameRegex.matcher((String)(params[0])).find();
    }
}
