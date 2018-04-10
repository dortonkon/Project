package com.example.colonizers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationG extends AppCompatActivity implements View.OnClickListener {

    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_g);

        play=(Button) findViewById(R.id.play);

        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play){
            Intent i = new Intent(this, Student.class);
            startActivity(i);

        }
    }
}
