package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtF_Number,edtS_Number;   // Variable Define
    TextView txtAnswer;                // Variable Define
    Button  btn1,btn2,btn3,btn4,btnClear;  // Variable Define

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button(); // New class Define

    }
    private void Button(){  //class Define

        edtF_Number=findViewById(R.id.edtF_Number);  //EdiText id  Define
         edtS_Number=findViewById(R.id.edtS_Number);   //EdiText id  Define
         txtAnswer=findViewById(R.id.txtAnswer); //TextView id  Define
          btn1=findViewById(R.id.btn1);     //Button id  Define
          btn2=findViewById(R.id.btn2);     //Button id  Define
          btn3=findViewById(R.id.btn3);    //Button id  Define
          btn4=findViewById(R.id.btn4);     //Button id  Define
          btnClear=findViewById(R.id.btnClear);    //Button id  Define

        Addition();
        Subscription();
        Multiplication();
        Division();
        Clear();
    }

    private void Addition() {

        btn1.setOnClickListener(a -> {

            String number_1 = edtF_Number.getText().toString();
            String number_2 = edtS_Number.getText().toString();

            int v1 = Integer.parseInt(number_1);
            int v2 = Integer.parseInt(number_2);
            int result;
            result = v1+v2;
            txtAnswer.setText(result+" ");
        });
    }
    private void Subscription(){

            btn2.setOnClickListener(s ->{

                String number_1=edtF_Number.getText().toString();
                String number_2=edtS_Number.getText().toString();

                int v1=Integer.parseInt(number_1);
                int v2=Integer.parseInt(number_2);
                int result;
                result=v1-v2;
                txtAnswer.setText(result+" ");
            });
    }
    private void Multiplication() {

        btn3.setOnClickListener(m -> {

            String number_1 = edtF_Number.getText().toString();
            String number_2 = edtS_Number.getText().toString();

            int v1 = Integer.parseInt(number_1);
            int v2 = Integer.parseInt(number_2);
            int result;
            result = v1*v2;
            txtAnswer.setText(result+" ");
        });
    }
    private void Division() {

        btn4.setOnClickListener(d -> {

            String number_1 = edtF_Number.getText().toString();
            String number_2 = edtS_Number.getText().toString();

            int v1 = Integer.parseInt(number_1);
            int v2 = Integer.parseInt(number_2);
            int result;
            result = v1/v2;
            txtAnswer.setText(result+" ");
        });
    }
    private void Clear(){

        btnClear.setOnClickListener(viee ->{

            edtF_Number.setText("");
            edtS_Number.setText("");
            txtAnswer.setText("");

        });
    }

}