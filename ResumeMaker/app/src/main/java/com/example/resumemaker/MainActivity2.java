package com.example.resumemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.resumemaker.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
//    TextView txtFName, txtEmail, txtLName, txtNumber, txtAddress, txtHobby, txtGender, txtMarital;
//    TextView txtMarks10, txtMarks12, txtMarksBCA, txtYear10, txtYear12, txtYearBCA;
//    TextView txtjobName, txtjobYear;
//    TextView txtskill;
//    ImageView imgBack;
ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id();
    }

    private void id() {
//        imgBack = findViewById(R.id.imgBack);
//        txtFName = findViewById(R.id.txtFName);
//        txtLName = findViewById(R.id.txtLName);
//        txtEmail = findViewById(R.id.txtEmail);
//        txtNumber = findViewById(R.id.txtNumber);
//        txtAddress = findViewById(R.id.txtAddress);
//
//        txtHobby = findViewById(R.id.txtHobby);
//
//        txtGender = findViewById(R.id.txtGender);
//        txtMarital = findViewById(R.id.txtMarital);
//
//        txtMarks10 = findViewById(R.id.txtMarks10);
//        txtYear10 = findViewById(R.id.txtYear10);
//
//        txtMarks12 = findViewById(R.id.txtMarks12);
//        txtYear12 = findViewById(R.id.txtYear12);
//
//        txtMarksBCA = findViewById(R.id.txtMarksBCA);
//        txtYearBCA = findViewById(R.id.txtYearBCA);
//
//        txtjobName = findViewById(R.id.txtjobName);
//        txtjobYear = findViewById(R.id.txtjobYear);
//
//        txtskill = findViewById(R.id.txtskill);


        view();
    }

    private void view() {
        String FName = getIntent().getStringExtra("FName");
        String LName = getIntent().getStringExtra("LName");
        String email = getIntent().getStringExtra("email");
        String number = getIntent().getStringExtra("m_number");
        String address = getIntent().getStringExtra("address");
        String gender = getIntent().getStringExtra("gender");

        String hobby = getIntent().getStringExtra("hobby");

        String Marital = getIntent().getStringExtra("Marital");

        String marks10 = getIntent().getStringExtra("marks10");
        String Year10 = getIntent().getStringExtra("year10");

        String marks12 = getIntent().getStringExtra("marks12");
        String Year12 = getIntent().getStringExtra("year12");

        String marksBCA = getIntent().getStringExtra("marksBCA");
        String YearBCA = getIntent().getStringExtra("yearBCA");
        //Experience
        String jobName = getIntent().getStringExtra("jobName");
        String jobYear = getIntent().getStringExtra("jobYear");
        //Your Skill
        String skill = getIntent().getStringExtra("skill");


        binding.txtFName.setText(FName);
        binding.txtLName.setText(LName);
        binding.txtEmail.setText(email);
        binding. txtNumber.setText(number);
        binding. txtAddress.setText(address);
        binding.txtGender.setText(gender);


        binding.txtHobby.setText(hobby);

        binding. txtMarital.setText(Marital);

        binding. txtMarks10.setText(marks10);
        binding. txtYear10.setText(Year10);

        binding. txtMarks12.setText(marks12);
        binding. txtYear12.setText(Year12);

        binding. txtMarksBCA.setText(marksBCA);
        binding. txtYearBCA.setText(YearBCA);

        binding.txtjobName.setText(jobName);
        binding. txtjobYear.setText(jobYear);

        binding. txtskill.setText(skill);

        clear();

    }

    private void clear() {
        binding. imgBack.setOnClickListener(i -> {
            binding.txtGender.setText("");
            binding. txtHobby.setText("");
            binding.  txtskill.setText("");
            binding. txtMarital.setText("");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();


        });
    }


}