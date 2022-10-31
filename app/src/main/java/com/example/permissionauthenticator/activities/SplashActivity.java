package com.example.permissionauthenticator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.permissionauthenticator.R;
import com.example.permissionauthenticator.validator.AuthenticateValidator;


public class SplashActivity extends AppCompatActivity {
    private AuthenticateValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
    }

    private void setListeners() {
    }

    private void initViews() {
    }
}