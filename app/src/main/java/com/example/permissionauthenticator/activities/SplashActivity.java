package com.example.permissionauthenticator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;

import com.example.permissionauthenticator.R;
import com.example.permissionauthenticator.validator.AuthenticateValidator;
import com.example.permissionauthenticator.validator.BatteryLevelValidator;
import com.example.permissionauthenticator.validator.PasswordValidator;
import com.example.permissionauthenticator.validator.UsernameValidator;
import com.example.permissionauthenticator.validator.WifiValidator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;


public class SplashActivity extends AppCompatActivity {
    private static final int STATUS_TIME_INTERVAL = 3000;
    private AuthenticateValidator validator;
    private EditText main_EDT_username;
    private EditText main_EDT_password;
    private MaterialTextView main_LBL_wifi;
    private MaterialTextView main_LBL_battery;
    private MaterialButton main_BTN_login;


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
        main_BTN_login.setOnClickListener(e -> checkValidLogin());
        Handler handler = new Handler();
       handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                checkStatus();
                handler.postDelayed(this, STATUS_TIME_INTERVAL);
            }
        }, STATUS_TIME_INTERVAL);
    }

    private void checkValidLogin() {
        validator.setUsername(main_EDT_username.getText().toString());
        validator.setPassword(main_EDT_password.getText().toString());
        if (validator.validate()) {
            setLabels();
            login();
        }
        
    }

    private void setLabels() {
        main_LBL_wifi.setTextColor(Color.GREEN);
        main_LBL_battery.setTextColor(Color.GREEN);
    }

    private void login() {
        startActivity(new Intent(this, SuccessActivity.class));
    }


    private void initViews() {
        main_EDT_username = findViewById(R.id.main_EDT_username);
        main_EDT_password = findViewById(R.id.main_EDT_password);
        main_LBL_wifi = findViewById(R.id.main_LBL_wifi);
        main_LBL_battery = findViewById(R.id.main_LBL_battery);
        main_BTN_login = findViewById(R.id.main_BTN_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(validator != null){
           checkStatus();
        }
    }

    private void checkStatus() {
        if (validator.checkBatteryStatus())
            main_LBL_battery.setTextColor(Color.GREEN);
        else
            main_LBL_battery.setTextColor(Color.RED);
        if (validator.checkWiFiStatus())
            main_LBL_wifi.setTextColor(Color.GREEN);
        else
            main_LBL_wifi.setTextColor(Color.RED);
    }
}