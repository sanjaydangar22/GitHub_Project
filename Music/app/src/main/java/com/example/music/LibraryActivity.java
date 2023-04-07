package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.example.music.databinding.ActivityLibraryBinding;

public class LibraryActivity extends AppCompatActivity {
    ActivityLibraryBinding libraryBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        libraryBinding = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(libraryBinding.getRoot());

        view();
    }

    private void view() {

        libraryBinding.layLHome.setOnClickListener(e -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
        libraryBinding.layLExplore.setOnClickListener(e -> {
            Intent i = new Intent(this, ExploreActivity.class);
            startActivity(i);
        });

    }
}
