package com.example.permissionauthenticator.validator;

import java.util.ArrayList;

public class AuthenticateValidator {
    private ArrayList<Rule> rules;

    public AuthenticateValidator() {
        rules = new ArrayList<>();
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public Rule getRule(int index){
        if (index < rules.size())
            return rules.get(index);
        throw new IndexOutOfBoundsException();
    }

    public AuthenticateValidator addRules(Rule rule) {
        rules.add(rule);
        return this;
    }
}
