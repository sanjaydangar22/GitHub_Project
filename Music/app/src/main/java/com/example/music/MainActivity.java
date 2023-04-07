package com.example.music;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.music.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        view();
    }

    private void view() {

        mainBinding.layMExplore.setOnClickListener(e->{
            Intent i=new Intent(this,ExploreActivity.class);
            startActivity(i);
        });
        mainBinding.layMLibery.setOnClickListener(e->{

            Intent i=new Intent(this,LibraryActivity.class);
            startActivity(i);
        });



//paly1
        String title=mainBinding.txtTitle1.getText().toString();
        String data=mainBinding.txtData.getText().toString();


        mainBinding.layPlay1.setOnClickListener(p1->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.ramsiya);
            send.putExtra("title",title);
            send.putExtra("data",data);
            send.putExtra("song","vishnu");
            startActivity(send);

        });
        //paly2
        String title2=mainBinding.txtTitle2.getText().toString();
        String data2=mainBinding.txtData2.getText().toString();


        mainBinding.layPlay2.setOnClickListener(p2->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.adiyogi);
            send.putExtra("title",title2);
            send.putExtra("data",data2);
            send.putExtra("song","bolo_har");
            startActivity(send);

        });
        //paly3
        String title3=mainBinding.txtTitle3.getText().toString();
        String data3=mainBinding.txtData3.getText().toString();


        mainBinding.layPlay3.setOnClickListener(p3->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.ramsiya1);
            send.putExtra("title",title3);
            send.putExtra("data",data3);
            send.putExtra("song","aditya");
            startActivity(send);

        });
        //paly4
        String title4=mainBinding.txtTitle4.getText().toString();
        String data4=mainBinding.txtData4.getText().toString();


        mainBinding.layPlay4.setOnClickListener(p4->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.kedarnath);
            send.putExtra("title",title4);
            send.putExtra("data",data4);
            send.putExtra("song","bam");
            startActivity(send);

        });
        //paly5
        String title5=mainBinding.txtTitlem.getText().toString();
        String data5=mainBinding.txtDatam.getText().toString();


        mainBinding.layPlaym.setOnClickListener(p5->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.mangalbhavan);
            send.putExtra("title",title5);
            send.putExtra("data",data5);
            send.putExtra("song","hanuman");
            startActivity(send);

        });
        //paly6
        String title6=mainBinding.txtTitle6.getText().toString();
        String data6=mainBinding.txtData6.getText().toString();


        mainBinding.layPlay6.setOnClickListener(p6->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.meriradhe);
            send.putExtra("title",title6);
            send.putExtra("data",data6);
            send.putExtra("song","vishnu");
            startActivity(send);

        });
        //paly7
        String title7=mainBinding.txtTitle7.getText().toString();
        String data7=mainBinding.txtData7.getText().toString();


        mainBinding.layPlay7.setOnClickListener(p7->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.ae_dill);
            send.putExtra("title",title7);
            send.putExtra("data",data7);
            send.putExtra("song","aedill");
            startActivity(send);

        });
        //paly8
        String title8=mainBinding.txtTitle8.getText().toString();
        String data8=mainBinding.txtData8.getText().toString();


        mainBinding.layPlay8.setOnClickListener(p8->{
            Intent send=new Intent(this,PlaySongActivity.class);
            send.putExtra("img",R.drawable.karhar_medan);
            send.putExtra("title",title8);
            send.putExtra("data",data8);
            send.putExtra("song","yarian");
            startActivity(send);

        });
    }
}