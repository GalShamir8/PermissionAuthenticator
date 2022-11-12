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

    public boolean validate(){
        for (Rule r: rules){
            if (!r.validate())
                return false;
        }
        return true;
    }

    public void setUsername(String usernameInput) {
        for (Rule r: rules){
            if (r instanceof UsernameValidator){
                ((UsernameValidator) r).setUsernameInput(usernameInput);
            }
        }
    }

    public void setPassword(String passwordInput) {
        for (Rule r: rules){
            if (r instanceof PasswordValidator){
                ((PasswordValidator) r).setPasswordInput(passwordInput);
            }
        }
    }

    public boolean checkWiFiStatus() {
        for (Rule r: rules){
            if (r instanceof WifiValidator){
                return r.validate();
            }
        }
        return false;
    }

    public boolean checkBatteryStatus() {
        for (Rule r: rules){
            if (r instanceof BatteryLevelValidator){
                return r.validate();
            }
        }
        return false;
    }
}
