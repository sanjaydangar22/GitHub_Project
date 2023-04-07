package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllCalculatorActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_calculator);

        view();

    }

    private void view() {

        btn1=findViewById(R.id.btnSimple);
        btn2=findViewById(R.id.btnCalculator);
        btn3=findViewById(R.id.btnAge);

        btn1.setOnClickListener(b-> {
            Intent i=new Intent(AllCalculatorActivity.this, Calculator2.class);
            startActivity(i);

        });
        btn2.setOnClickListener(s->{
            Intent i=new Intent(AllCalculatorActivity.this, MainActivity.class);
            startActivity(i);

        });
        btn3.setOnClickListener(d->{
            Intent i=new Intent(AllCalculatorActivity.this, Age.class);
            startActivity(i);

        });
    }
}