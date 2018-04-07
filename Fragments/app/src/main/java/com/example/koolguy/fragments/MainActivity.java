package com.example.koolguy.fragments;



import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BlankFragment fragment = new BlankFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();




    }
}
