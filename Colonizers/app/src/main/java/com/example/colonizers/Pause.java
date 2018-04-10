package com.example.colonizers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pause extends AppCompatActivity implements View.OnClickListener {

    Button reset;
    Button menu;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);

        reset = (Button) findViewById(R.id.reset);
        menu = (Button) findViewById(R.id.menu);
        go = (Button) findViewById(R.id.go);

        reset.setOnClickListener(this);
        menu.setOnClickListener(this);
        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reset:
                Intent i = getIntent();
                switch (Integer.parseInt(i.getStringExtra("key"))) {
                    case 1:
                        Intent i1 = new Intent(this, PrimarySchool.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(this, FourthForm.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(this, NinthForm.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(this, EleventhForm.class);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(this, Student.class);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(this, PrimarySchool.class);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(this, PrimarySchool.class);
                        startActivity(i7);
                        break;
                }

                finish();
                break;
            case R.id.menu:
                Intent i2 = new Intent(this, MainActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.go:
                finish();
                break;
        }
    }
}
