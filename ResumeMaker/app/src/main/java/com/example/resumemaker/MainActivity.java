package com.example.resumemaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Person information define
    EditText edtFName, edtLName, edtEmail, edtNumber, edtAddress;
    //Gender
    RadioGroup rgGroup;

    //Hobby
    CheckBox chkRedding, chkJourney, chkSports;
    //Marital Status
    RadioGroup maGroup;
    RadioButton rbMale, rbFemale, rbOther;

    //Eduction information
    EditText edtMarks10, edtMarks12, edtMarksBCA, edtYear10, edtYear12, edtYearBCA;
    //Experience
    EditText edtExJob, edtExYear;
    //Your Skill
    CheckBox chkC, chkCpp, chkJava, chkHtml, chkCss, chkJavaScript, chkChase, chkPython, chkKotlin, chkAndroid, chkWab, chkFlutter;
    //Button
    AppCompatButton btnSubmit, btnClear;

    // Define variable
    String gender, hobby1, hobby2, hobby3, Marital, skillC, skillCpp, skillJava, skillHtml, skillCss, skillJS, skillChase, skillPython, skillKotlin, skillAndroid, skillWab, skillFlutter;


    StringBuilder hobby = new StringBuilder();
    StringBuilder skill = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idDefine();
    }

    private void idDefine() {
        //Person information define
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtEmail = findViewById(R.id.edtEmail);
        edtNumber = findViewById(R.id.edtNumber);
        edtAddress = findViewById(R.id.edtAddress);

        //Gender
        rgGroup = findViewById(R.id.rgGroup);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);

        //Hobby
        chkRedding = findViewById(R.id.chkRedding);
        chkJourney = findViewById(R.id.chkJourney);
        chkSports = findViewById(R.id.chkSports);
        //Marital Status
        maGroup = findViewById(R.id.maGroup);

        //Eduction information
        edtMarks10 = findViewById(R.id.edtMarks10);
        edtMarks12 = findViewById(R.id.edtMarks12);
        edtMarksBCA = findViewById(R.id.edtMarksBCA);

        edtYear10 = findViewById(R.id.edtYear10);
        edtYear12 = findViewById(R.id.edtYear12);
        edtYearBCA = findViewById(R.id.edtYearBCA);
        //Experience
        edtExJob = findViewById(R.id.edtExJob);
        edtExYear = findViewById(R.id.edtExYear);
        //Your Skill
        chkC = findViewById(R.id.chkC);
        chkCpp = findViewById(R.id.chkCpp);
        chkJava = findViewById(R.id.chkJava);

        chkHtml = findViewById(R.id.chkHtml);
        chkCss = findViewById(R.id.chkCss);
        chkJavaScript = findViewById(R.id.chkJavaScript);

        chkChase = findViewById(R.id.chkChase);
        chkPython = findViewById(R.id.chkPython);
        chkKotlin = findViewById(R.id.chkKotlin);

        chkAndroid = findViewById(R.id.chkAndroid);
        chkWab = findViewById(R.id.chkWab);
        chkFlutter = findViewById(R.id.chkFlutter);
        //Button
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);


        View();
        Clear();

    }

    private void View() {
        btnSubmit.setOnClickListener(s -> {

            //personal information
            String f_name = edtFName.getText().toString();
            String l_name = edtLName.getText().toString();
            String email = edtEmail.getText().toString();
            String m_number = edtNumber.getText().toString();
            String address = edtAddress.getText().toString();


            //Gender
            int selectedId = rgGroup.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);


            if (selectedId != -1) {
                gender = rb.getText().toString();
            }
            //Hobby
            if (chkRedding.isChecked()) {
                // hobby1 = chkRedding.getText().toString();
                hobby.append("" + chkRedding.getText().toString());
            }
            if (chkJourney.isChecked()) {
                // hobby2 = chkJourney.getText().toString();
                hobby.append(" " + chkJourney.getText().toString());
            }
            if (chkSports.isChecked()) {
                //  hobby3 = chkSports.getText().toString();
                hobby.append(" " + chkSports.getText().toString());

            }


            //Marital Status
            int selectedId2 = maGroup.getCheckedRadioButtonId();
            RadioButton rb2 = findViewById(selectedId2);
            if (selectedId2 != -1) {
                Marital = rb2.getText().toString();
            }


            //Education information
            // 10th marks & year
            String marks10 = edtMarks10.getText().toString();
            String year10 = edtYear10.getText().toString();

            // 12th marks & year
            String marks12 = edtMarks12.getText().toString();
            String year12 = edtYear12.getText().toString();

            // BCA marks & year
            String marksBca = edtMarksBCA.getText().toString();
            String yearBca = edtYearBCA.getText().toString();


            //Experience Define
            String jobName = edtExJob.getText().toString();
            String jobYear = edtExYear.getText().toString();

            //Your Skill
            if (chkC.isChecked()) {
                // skillC = chkC.getText().toString();
                skill.append("  " + chkC.getText().toString());
            }
            if (chkCpp.isChecked()) {
                // skillCpp = chkCpp.getText().toString();
                skill.append("  " + chkCpp.getText().toString());
            }
            if (chkJava.isChecked()) {
                //skillJava = chkJava.getText().toString();
                skill.append("  " + chkJava.getText().toString());
            }
            if (chkHtml.isChecked()) {
                //skillHtml = chkHtml.getText().toString();
                skill.append("  " + chkHtml.getText().toString());
            }
            if (chkCss.isChecked()) {
                // skillCss = chkCss.getText().toString();
                skill.append("  " + chkCss.getText().toString());
            }
            if (chkJavaScript.isChecked()) {
                //skillJS = chkJavaScript.getText().toString();
                skill.append("  " + chkJavaScript.getText().toString());
            }
            if (chkChase.isChecked()) {
                //skillChase = chkChase.getText().toString();
                skill.append("  " + chkChase.getText().toString());
            }
            if (chkPython.isChecked()) {
                // skillPython = chkPython.getText().toString();
                skill.append("  " + chkPython.getText().toString());
            }
            if (chkKotlin.isChecked()) {
                // skillKotlin = chkKotlin.getText().toString();
                skill.append("  " + chkKotlin.getText().toString());
            }
            if (chkAndroid.isChecked()) {
                //  skillAndroid = chkAndroid.getText().toString();
                skill.append("  " + chkAndroid.getText().toString());
            }
            if (chkWab.isChecked()) {
                // skillWab = chkWab.getText().toString();
                skill.append("  " + chkWab.getText().toString());
            }
            if (chkFlutter.isChecked()) {
                //skillFlutter = chkFlutter.getText().toString();
                skill.append("  " + chkFlutter.getText().toString());
            }

            if (f_name.isEmpty()) {
                //Log.e("TAG", "First Name filed is empty ");
                Toast.makeText(this, "Please Enter your First Name", Toast.LENGTH_SHORT).show();
            } else if (f_name.length() < 3) {
                //Log.e("TAG", "First Name filed is empty ");
                Toast.makeText(this, "Minimum 3 character", Toast.LENGTH_SHORT).show();
            } else if (l_name.isEmpty()) {
                //  Log.e("TAG", "Last Name filed is empty ");
                Toast.makeText(this, "Please Enter your Last Name", Toast.LENGTH_SHORT).show();
            } else if (l_name.length() < 3) {
                //Log.e("TAG", "First Name filed is empty ");
                Toast.makeText(this, "Minimum 3 character", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                //Log.e("TAG", "Email  filed is empty ");
                Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
            } else if (m_number.isEmpty()) {
                //Log.e("TAG", "Mobil number filed is empty ");
                Toast.makeText(this, "Please Enter Your Mobil Number", Toast.LENGTH_SHORT).show();

            } else if (m_number.length() < 10 != m_number.length() > 10) {
                //Log.e("TAG", "Mobil number filed is empty ");
                Toast.makeText(this, " Mobil Number Valid is 10 number", Toast.LENGTH_SHORT).show();

            } else if (address.isEmpty()) {
                //Log.e("TAG", "Address filed is empty ");
                Toast.makeText(this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();

            } else if (gender == null) {
                //Log.e("TAG", "Gender is null ");
                Toast.makeText(this, "Please Select Your Gender ", Toast.LENGTH_SHORT).show();
            }
//                   else if (hobby1 == null && hobby2 == null && hobby3 == null) {
//                //  Log.e("TAG", "Hobby is null ");
//                Toast.makeText(this, "Please Select Your Hobby", Toast.LENGTH_SHORT).show();
//            }
            else if (hobby == null) {
                //  Log.e("TAG", "Hobby is null ");
                Toast.makeText(this, "Please Select Your Hobby", Toast.LENGTH_SHORT).show();
            } else if (Marital == null) {
                //  Log.e("TAG", "Marital Status is null ");
                Toast.makeText(this, "Please Select Your Marital Status", Toast.LENGTH_SHORT).show();
            } else if (marks10.isEmpty()) {
                // Log.e("TAG", "10th Marks  is empty ");
                Toast.makeText(this, "Enter Your 10th Passing Marks", Toast.LENGTH_SHORT).show();
            } else if (year10.isEmpty()) {
                //   Log.e("TAG", "10th Year is empty ");
                Toast.makeText(this, "Enter Your 10th Passing Year", Toast.LENGTH_SHORT).show();

            } else if (marks12.isEmpty()) {
                Log.e("TAG", "12th Marks  is empty ");
                Toast.makeText(this, "Enter Your 12th Passing Marks", Toast.LENGTH_SHORT).show();
            } else if (year12.isEmpty()) {
                //Log.e("TAG", "12th Year is empty ");
                Toast.makeText(this, "Enter Your 12th Passing Year", Toast.LENGTH_SHORT).show();
            } else if (marksBca.isEmpty()) {
                // Log.e("TAG", "BCA Marks  is empty ");
                Toast.makeText(this, "Enter Your BCA Passing Marks", Toast.LENGTH_SHORT).show();
            } else if (yearBca.isEmpty()) {
                //Log.e("TAG", "BCA Year is empty ");
                Toast.makeText(this, "Enter Your BCA Passing Year", Toast.LENGTH_SHORT).show();
            } else if (jobName.isEmpty()) {
                //Log.e("TAG", "Your job name  is empty ");
                Toast.makeText(this, "Please Enter your Job Experience ", Toast.LENGTH_SHORT).show();
            } else if (jobYear.isEmpty()) {
                //Log.e("TAG", "Your job year is empty ");
                Toast.makeText(this, "Please Enter your Job Experience Year", Toast.LENGTH_SHORT).show();

            } else if (skill == null) {
                //Log.e("TAG", "Your Skill is null ");
                Toast.makeText(this, "Please Select Your Skill ", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                //person information
                intent.putExtra("FName", f_name);
                intent.putExtra("LName", l_name);
                intent.putExtra("email", email);
                intent.putExtra("m_number", m_number);
                intent.putExtra("address", address);

                //Gender
                intent.putExtra("gender", gender);
                //Hobby
                intent.putExtra("hobby", "" + hobby);


                //Marital
                intent.putExtra("Marital", Marital);
                //Education information
                intent.putExtra("marks10", marks10);
                intent.putExtra("year10", year10);

                intent.putExtra("marks12", marks12);
                intent.putExtra("year12", year12);

                intent.putExtra("marksBCA", marksBca);
                intent.putExtra("yearBCA", yearBca);
                //Experience
                intent.putExtra("jobName", "Job : -  " + jobName);
                intent.putExtra("jobYear", "Year: -  " + jobYear);
                //Your Skill
                intent.putExtra("skill", "" + skill);


                AlertDialog.Builder savevariable = new AlertDialog.Builder(this);
                savevariable.setTitle("Save");
                savevariable.setMessage("Are Sure Your Data is Correct");
                savevariable.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Your Data is Save", Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder uploadvariable = new AlertDialog.Builder(MainActivity.this);
                        uploadvariable.setTitle("Upload");
                        uploadvariable.setMessage("Are You Sure Data is Upload");
                        uploadvariable.setPositiveButton("Upload", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Data Upload Success", Toast.LENGTH_SHORT).show();


                                startActivity(intent);
                                finish();

                            }
                        });
                        uploadvariable.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Data Not Upload", Toast.LENGTH_SHORT).show();

                            }
                        });
                        uploadvariable.setCancelable(false);
                        uploadvariable.show();
                    }

                });
                savevariable.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Your Data is Not Save", Toast.LENGTH_SHORT).show();

                    }
                });
                savevariable.setCancelable(false);
                savevariable.show();

            }
        });

    }

    private void Clear() {
        btnClear.setOnClickListener(c -> {
            edtFName.setText("");
            edtLName.setText("");
            edtEmail.setText("");
            edtNumber.setText("");
            edtAddress.setText("");
            edtFName.setText("");
            //Gender

            rgGroup.clearCheck();


            //Hobby
            chkRedding.setChecked(false);
            chkJourney.setChecked(false);
            chkSports.setChecked(false);
            //Marital Status
            maGroup.clearCheck();

            //Eduction information
            edtMarks10.setText("");
            edtMarks12.setText("");
            edtMarksBCA.setText("");

            edtYear10.setText("");
            edtYear12.setText("");
            edtYearBCA.setText("");
            //Experience
            edtExJob.setText("");
            edtExYear.setText("");
            //Your Skill
            chkC.setChecked(false);
            chkCpp.setChecked(false);
            chkJava.setChecked(false);

            chkHtml.setChecked(false);
            chkCss.setChecked(false);
            chkJavaScript.setChecked(false);

            chkChase.setChecked(false);
            chkPython.setChecked(false);
            chkKotlin.setChecked(false);

            chkAndroid.setChecked(false);
            chkWab.setChecked(false);
            chkFlutter.setChecked(false);
        });
    }
}