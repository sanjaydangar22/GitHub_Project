package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Age extends AppCompatActivity {
    TextView txtName, txtAns1, txtAns2, txtAns3;
    EditText edtName, edtTd1, edtTd2, edtTd3, edtDb1, edtDb2, edtDb3;
    AppCompatButton btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        Button();
        Calculate();
        Clear();
    }


    private void Button() {

        edtName = findViewById(R.id.edtName);
        txtName = findViewById(R.id.txtName);

        edtTd1 = findViewById(R.id.edtTd1);
        edtTd2 = findViewById(R.id.edtTd2);
        edtTd3 = findViewById(R.id.edtTd3);

        edtDb1 = findViewById(R.id.edtDb1);
        edtDb2 = findViewById(R.id.edtDb2);
        edtDb3 = findViewById(R.id.edtDb3);

        txtAns1 = findViewById(R.id.txtAns1);
        txtAns2 = findViewById(R.id.txtAns2);
        txtAns3 = findViewById(R.id.txtAns3);

        btnCalculate = findViewById(R.id.btnCalculator);
        btnClear = findViewById(R.id.btnClear);
    }

    private void Calculate() {
        btnCalculate.setOnClickListener(a -> {
            String name = edtName.getText().toString();

            String date1 = edtTd1.getText().toString();
            String date2 = edtDb1.getText().toString();

            String month1 = edtTd2.getText().toString();
            String month2 = edtDb2.getText().toString();

            String year1 = edtTd3.getText().toString();
            String year2 = edtDb3.getText().toString();

            txtName.setText(name + "");

            int d1 = Integer.parseInt(date1);
            int d2 = Integer.parseInt(date2);
            int dans;
            dans = d1 - d2;
            txtAns1.setText(dans + "");

            int m1 = Integer.parseInt(month1);
            int m2 = Integer.parseInt(month2);
            int mans;
            mans = m1 - m2;
            txtAns2.setText(mans + "");

            long y1 = Integer.parseInt(year1);
            long y2 = Integer.parseInt(year2);
            long yans;
            yans = y1 - y2;
            txtAns3.setText(yans + "");


        });
    }

    private void Clear() {
        btnClear.setOnClickListener(b -> {
            edtName.setText("");
            txtName.setText("");

            edtTd1.setText("");
            edtTd2.setText("");
            edtTd3.setText("");

            edtDb1.setText("");
            edtDb2.setText("");
            edtDb3.setText("");

            txtAns1.setText("");
            txtAns2.setText("");
            txtAns3.setText("");

        });
    }
}