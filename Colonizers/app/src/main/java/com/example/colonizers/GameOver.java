package com.example.colonizers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity implements View.OnClickListener {

    String text;
    Button reset;
    Button menu;
    TextView count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        reset = (Button) findViewById(R.id.reset);
        menu = (Button) findViewById(R.id.menu);
        count = (TextView) findViewById(R.id.count);

        reset.setOnClickListener(this);
        menu.setOnClickListener(this);

        Intent i = getIntent();
        text = i.getStringExtra("Score");
        count.setText("Очки: " + text);


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
        }
    }
}
