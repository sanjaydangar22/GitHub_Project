package com.example.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.music.databinding.ActivityPlaySongBinding;

public class PlaySongActivity extends AppCompatActivity {

    MediaPlayer mp;
    ActivityPlaySongBinding playSongBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playSongBinding = ActivityPlaySongBinding.inflate(getLayoutInflater());
        setContentView(playSongBinding.getRoot());

        view();
    }

    private void view() {

        playSongBinding.imgBack.setOnClickListener(b -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int img = bundle.getInt("img");
            playSongBinding.imgShow.setImageResource(img);
        }
        String title = getIntent().getStringExtra("title");
        String data = getIntent().getStringExtra("data");

        String song = getIntent().getStringExtra("song");

        playSongBinding.imgPlay.setOnClickListener(p -> {



            switch (song) {
                case "vishnu":
                    mp = MediaPlayer.create(this, R.raw.vishnu_stotram);

                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p1 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });

                    break;
                case "bolo_har":
                    mp = MediaPlayer.create(this, R.raw.bolo_har_har);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p2 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "aditya":
                    mp = MediaPlayer.create(this, R.raw.aditya_hrudayam_stotram);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p3 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "bam":
                    mp = MediaPlayer.create(this, R.raw.bham);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p4 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "hanuman":
                    mp = MediaPlayer.create(this, R.raw.hanuman_chalisa);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p5 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "vishnu1":
                    mp = MediaPlayer.create(this, R.raw.aigiri);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p6 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "aedill":
                    mp = MediaPlayer.create(this, R.raw.ae_dill);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p7 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
                case "yarian":
                    mp = MediaPlayer.create(this, R.raw.yaarian);
                    mp.start();
                    playSongBinding.imgPlay.setImageResource(R.drawable.pause_circle);

                    playSongBinding.imgPlay.setOnClickListener(p3 -> {
                        if (mp.isPlaying()) {

                            mp.stop();
                        }
                        recreate();

                    });
                    break;
            }


        });
        playSongBinding.txtTitle.setText(title);
        playSongBinding.txtData.setText(data);


    }
    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();

    }


}
