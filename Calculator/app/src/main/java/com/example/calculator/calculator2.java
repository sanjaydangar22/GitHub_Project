package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator2 extends AppCompatActivity {
    EditText edtNo1, edtNo2, edtNo3, edtNo4;
    TextView txtAns;
    AppCompatButton btnTotal, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);

        id();
        Total();
        Clear();
    }

    private void id() {
        edtNo1 = findViewById(R.id.edtNo1);
        edtNo2 = findViewById(R.id.edtNo2);
        edtNo3 = findViewById(R.id.edtNo3);
        edtNo4 = findViewById(R.id.edtNo4);
        txtAns = findViewById(R.id.txtAns);
        btnTotal = findViewById(R.id.btnTotal);
        btnClear = findViewById(R.id.btnClear);

    }

    private void Total() {
        btnTotal.setOnClickListener(view -> {
            String number1 = edtNo1.getText().toString();
            String number2 = edtNo2.getText().toString();
            String number3 = edtNo3.getText().toString();
            String number4 = edtNo4.getText().toString();

            int v1 = Integer.parseInt(number1);
            int v2 = Integer.parseInt(number2);
            int v3 = Integer.parseInt(number3);
            int v4 = Integer.parseInt(number4);
            int Answer;
            Answer = v1 + v2 + v3 + v4;
            txtAns.setText(Answer + "");
        });
    }

    private void Clear() {
        btnClear.setOnClickListener(d -> {
            edtNo1.setText("");
            edtNo2.setText("");
            edtNo3.setText("");
            edtNo4.setText("");
            txtAns.setText("");
        });
    }
}