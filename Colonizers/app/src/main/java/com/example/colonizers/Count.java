package com.example.colonizers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Count extends AppCompatActivity implements View.OnClickListener {

    final String key1 = "ScorePrimarySchool";
    final String key2 = "ScoreFourthForm";
    final String key3 = "ScoreNinthForm";
    final String key4 = "ScoreEleventhForm";
    Button primarySchool;
    Button fourthForm;
    Button ninthForm;
    Button eleventhForm;
    Button student;
    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        primarySchool = (Button) findViewById(R.id.primarySchool);
        fourthForm = (Button) findViewById(R.id.fourthForm);
        ninthForm = (Button) findViewById(R.id.ninthForm);
        eleventhForm = (Button) findViewById(R.id.eleventhForm);
        student = (Button) findViewById(R.id.student);

        primarySchool.setOnClickListener(this);
        fourthForm.setOnClickListener(this);
        ninthForm.setOnClickListener(this);
        eleventhForm.setOnClickListener(this);
        student.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.primarySchool:
                SP = getSharedPreferences("save", MODE_PRIVATE);


                    Intent i1 = new Intent(this, PrimarySchool.class);
                    startActivity(i1);

                break;
            case R.id.fourthForm:
                SP = getSharedPreferences("save", MODE_PRIVATE);
                if(Integer.parseInt(SP.getString(key1, ""))<500) {
                    Toast.makeText(Count.this, "Наберите в уровне Начальная школа 500 очков", Toast.LENGTH_SHORT).show();
                } else {
                    i1 = new Intent(this, FourthForm.class);
                    startActivity(i1);
                }
                break;
            case R.id.ninthForm:
                SP = getSharedPreferences("save", MODE_PRIVATE);
                if(Integer.parseInt(SP.getString(key1, ""))<500) {
                    Toast.makeText(Count.this, "Наберите в уровне Начальная школа 500 очков", Toast.LENGTH_SHORT).show();
                } else {
                     i1 = new Intent(this, NinthForm.class);
                    startActivity(i1);
                }
                break;
            case R.id.eleventhForm:
                SP = getSharedPreferences("save", MODE_PRIVATE);
                if(Integer.parseInt(SP.getString(key1, ""))<500) {
                    Toast.makeText(Count.this, "Наберите в уровне Начальная школа 500 очков", Toast.LENGTH_SHORT).show();
                } else {
                     i1 = new Intent(this, EleventhForm.class);
                    startActivity(i1);
                }
                break;
            case R.id.student:
                SP = getSharedPreferences("save", MODE_PRIVATE);

                    i1 = new Intent(this, Student.class);
                    startActivity(i1);

                break;
        }
    }
}
