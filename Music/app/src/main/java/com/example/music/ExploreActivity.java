package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.music.databinding.ActivityExploreBinding;


public class ExploreActivity extends AppCompatActivity {

    ActivityExploreBinding exploreBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exploreBinding=ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(exploreBinding.getRoot());

        view();
    }

    private void view() {

        exploreBinding.layEHome.setOnClickListener(e->{
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        });
        exploreBinding.layELibery.setOnClickListener(e->{
            Intent i=new Intent(this,LibraryActivity.class);
            startActivity(i);
        });

    }
}