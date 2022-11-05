package com.example.permissionauthenticator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.permissionauthenticator.R;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ImageView success_IMG = findViewById(R.id.success_IMG);
       success_IMG.setImageResource(R.drawable.success_img);
    }
}