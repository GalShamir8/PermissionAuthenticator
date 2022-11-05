package com.example.permissionauthenticator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.permissionauthenticator.R;
import com.example.permissionauthenticator.validator.AuthenticateValidator;
import com.example.permissionauthenticator.validator.BatteryLevelValidator;
import com.example.permissionauthenticator.validator.PasswordValidator;
import com.example.permissionauthenticator.validator.UsernameValidator;
import com.example.permissionauthenticator.validator.WifiValidator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;


public class SplashActivity extends AppCompatActivity {
    private AuthenticateValidator validator;
    private MaterialTextView txt;
    private MaterialButton btn;


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
                .addRules(new BatteryLevelValidator(getApplicationContext()))
                .addRules(new WifiValidator(getApplicationContext()));
    }

    private void setListeners() {
        btn.setOnClickListener(e -> setTxt("" + validator.validate()));
    }

    private void setTxt(String message) {
        txt.setText(message);
    }

    private void initViews() {
        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
    }
}