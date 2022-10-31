package com.example.permissionauthenticator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.permissionauthenticator.R;
import com.example.permissionauthenticator.validator.AuthenticateValidator;
import com.example.permissionauthenticator.validator.BatteryLevelValidator;
import com.example.permissionauthenticator.validator.FlashSensorValidator;
import com.example.permissionauthenticator.validator.PasswordValidator;
import com.example.permissionauthenticator.validator.UsernameValidator;
import com.example.permissionauthenticator.validator.WifiValidator;


public class SplashActivity extends AppCompatActivity {
    private AuthenticateValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initValidator();
        initViews();
        setListeners();
    }

    private void initValidator() {
        validator = new AuthenticateValidator()
                .addRules(new UsernameValidator())
                .addRules(new PasswordValidator())
                .addRules(new FlashSensorValidator())
                .addRules(new BatteryLevelValidator())
                .addRules(new WifiValidator());
    }

    private void setListeners() {
    }

    private void initViews() {
    }
}