package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.music.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding splashScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashScreenBinding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(splashScreenBinding.getRoot());

        Intent splash=new Intent(this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(splash);
                finish();
            }
        },1000);
    }
}