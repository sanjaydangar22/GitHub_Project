package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        //Method First
//        Intent i=new Intent(this,MainActivity.class);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(i);
//                finish();
//            }
//        },1000);

//method second
        Intent i=new Intent(this,MainActivity.class);
        new Handler().postDelayed(() -> {
            startActivity(i);
            finish();
        },1000);
    }
}