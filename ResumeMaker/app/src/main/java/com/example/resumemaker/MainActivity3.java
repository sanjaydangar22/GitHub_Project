package com.example.resumemaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {


    Button btnsingleChoice;
    String[] listarr={"pizza","burger","browny","bread"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       initView();
    }

    private void initView() {
        btnsingleChoice=findViewById(R.id.btnsingleChoice);

        btnsingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3.this);
                builder.setTitle("Choose item");
                builder.setSingleChoiceItems(listarr, 3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    String selectedItem=listarr[i];
                    }
                });

                builder.setCancelable(false);
                builder.show();



            }
        });
    }
}