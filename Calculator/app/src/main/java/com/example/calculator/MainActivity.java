package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import android.os.Bundle;

import android.util.Log;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int n1=0, n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0,n9=0,n0=0, ans;
    AppCompatButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnSub, btnMuliti, btnDivision, btnAc, btnEqual;
    TextView txtAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Buttons_0to9(); // Define Buttons


    }

    private void Buttons_0to9() {


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        txtAns = findViewById(R.id.txtAns);
        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnMuliti = findViewById(R.id.btnMulti);
        btnDivision = findViewById(R.id.btnDivision);
        btnAc = findViewById(R.id.btnAc);
        btnEqual = findViewById(R.id.btnEqual);

        Number();
        Addition();
        Subscription();
        Multiplication();
        Division();
        Clear();

    }

    private void Number() {


        btn1.setOnClickListener(vb ->{
            n1=1;
        });
        btn2.setOnClickListener(vc -> {n2=2;});
        btn3.setOnClickListener(vd -> {n3=3;});
        btn4.setOnClickListener(ve -> {n4=4;});
        btn5.setOnClickListener(vf -> {n5=5;});
        btn6.setOnClickListener(vg -> {n6=6;});
        btn7.setOnClickListener(vh -> {n7=7;});
        btn8.setOnClickListener(vi -> {n8=8;});
        btn9.setOnClickListener(vj -> {n9=9;});
        btn0.setOnClickListener(va -> {
            n0=0;
        });




    }


    private void Addition() {
        btnPlus.setOnClickListener(View -> {

        ans=n1+n2+n3+n4+n5+n6+n7+n8+n9+n0;


            txtAns.setText(ans+"");


        });
    }

    private void Subscription() {
        btnSub.setOnClickListener(b -> {
            ans=n9-n8-n7-n6-n5-n4-n3-n2-n1-n0;


            txtAns.setText(ans+"");


        });
    }

    private void Multiplication() {
        btnMuliti.setOnClickListener(c -> {



        });
    }

    private void Division() {
        btnDivision.setOnClickListener(d -> {


        });
    }

    private void Clear() {
        btnAc.setOnClickListener(ac -> {
            n0=0;
            n1=0;
            n2=0;
            n3=0;
            n4=0;
            n5=0;
            n6=0;
            n7=0;
            n8=0;
            n9=0;
            txtAns.setText("");
    });

    }
}


