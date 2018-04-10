package com.example.colonizers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EleventhForm extends AppCompatActivity implements View.OnClickListener{

    final String key4 = "ScoreEleventhForm";
    boolean checkPause = false;
    boolean pause = false;
    int bonus;
    int lifes;
    int Scores;
    double s;
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    Button but7;
    Button but8;
    Button but9;
    Button but10;
    Button but11;
    Button but12;
    Button but13;
    Button but14;
    Button but15;
    Button but16;
    Button paused;
    TextView record;
    TextView life;
    TextView score;
    TextView time;
    TextView example;
    int firstNum;
    int secondNum;
    int rez;
    Button[] arrBut = new Button[16];
    SharedPreferences SP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_form);

        Timer t = new Timer();
        t.start();
        lifes = 3;

        record = (TextView) findViewById(R.id.record);
        life = (TextView) findViewById(R.id.life);
        score = (TextView) findViewById(R.id.score);
        example = (TextView) findViewById(R.id.example);
        time = (TextView) findViewById(R.id.time);


        arrBut[0] = but1 = (Button) findViewById(R.id.but1);
        arrBut[1] = but2 = (Button) findViewById(R.id.but2);
        arrBut[2] = but3 = (Button) findViewById(R.id.but3);
        arrBut[3] = but4 = (Button) findViewById(R.id.but4);
        arrBut[4] = but5 = (Button) findViewById(R.id.but5);
        arrBut[5] = but6 = (Button) findViewById(R.id.but6);
        arrBut[6] = but7 = (Button) findViewById(R.id.but7);
        arrBut[7] = but8 = (Button) findViewById(R.id.but8);
        arrBut[8] = but9 = (Button) findViewById(R.id.but9);
        arrBut[9] = but10 = (Button) findViewById(R.id.but10);
        arrBut[10] = but11 = (Button) findViewById(R.id.but11);
        arrBut[11] = but12 = (Button) findViewById(R.id.but12);
        arrBut[12] = but13 = (Button) findViewById(R.id.but13);
        arrBut[13] = but14 = (Button) findViewById(R.id.but14);
        arrBut[14] = but15 = (Button) findViewById(R.id.but15);
        arrBut[15] = but16 = (Button) findViewById(R.id.but16);
        paused = (Button) findViewById(R.id.pause);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but10.setOnClickListener(this);
        but11.setOnClickListener(this);
        but12.setOnClickListener(this);
        but13.setOnClickListener(this);
        but14.setOnClickListener(this);
        but15.setOnClickListener(this);
        but16.setOnClickListener(this);
        paused.setOnClickListener(this);


        Play();


    }

    protected void Play() {
        s = 15;
        SP = getSharedPreferences("save", MODE_PRIVATE);
        if (SP.getString(key4, "").equals("")) {
            SharedPreferences.Editor editor = SP.edit();
            editor.putString(key4, "0");
            editor.commit();
        }
        if (Integer.parseInt(SP.getString(key4, "")) < Scores) {
            SP = getSharedPreferences("save", MODE_PRIVATE);
            SharedPreferences.Editor editor = SP.edit();
            editor.putString(key4, String.valueOf(Scores));
            editor.commit();
        }
        if (SP.getString(key4, "").equals("0")) {
            record.setText("Рекорд: 0");
        } else record.setText("Рекорд: " + SP.getString(key4, ""));

        int colorAnswer=(int) (Math.random() * 4);
        switch (colorAnswer) {
            case 0:
                example.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.elipsegreen, 0);
                break;
            case 1:
                example.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.elipseorange, 0);
                break;
            case 2:
                example.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.elipsepink, 0);
                break;
            case 3:
                example.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.elipsered, 0);
                break;
        }

        switch ((int) (Math.random() * 7)) {
            case 0:
                firstNum = (int) (Math.random() * 91);
                secondNum = (int) (Math.random() * 91);
                rez = firstNum + secondNum;
                example.setText(firstNum + " + " + secondNum + " = ");
                break;
            case 1:
                secondNum = (int) (Math.random() * 91);
                firstNum = (int) (Math.random() * (91 - secondNum) + secondNum);
                rez = firstNum - secondNum;
                example.setText(firstNum + " - " + secondNum + " = ");
                break;
            case 2:
                secondNum = (int) (Math.random() * 18);
                firstNum = (int) (Math.random() * 18);
                rez = firstNum * secondNum;
                example.setText(firstNum + " • " + secondNum + " = ");
                break;
            case 3:
                firstNum = (int) (Math.random() * 18);
                secondNum = ((int) (Math.random() * 18) + 1);
                rez = firstNum;
                example.setText(firstNum * secondNum + " : " + secondNum + " = ");
                break;
            case 4:
                firstNum = (int) (Math.random() * 23);
                rez = firstNum * firstNum;
                example.setText(firstNum + "² = ");
                break;
            case 5:
                firstNum = (int) (Math.random() * 23);
                rez = firstNum;
                example.setText("√" + firstNum * firstNum + " = ");
                break;
            case 6:
                switch (((int) (Math.random() * 8))+1){
                    case 1:
                        rez=1;
                        example.setText("sin(" + 90 +"°) = ");
                        break;
                    case 2:
                        rez=1;
                        example.setText("cos(" + 180 +"°) = ");
                        break;
                    case 3:
                        rez=1;
                        example.setText("cos(" + 0 +"°) = ");
                        break;
                    case 4:
                        rez=0;
                        example.setText("sin(" + 0 +"°) = ");
                        break;
                    case 5:
                        rez=0;
                        example.setText("sin(" + 180 +"°) = ");
                        break;
                    case 6:
                        rez=0;
                        example.setText("cos(" + 90 +"°) = ");
                        break;
                    case 7:
                        rez=1;
                        example.setText("tg(" + 45 +"°) = ");
                        break;
                    case 8:
                        rez=1;
                        example.setText("ctg(" + 45 +"°) = ");
                        break;
                }
                break;


        }

        for (Button but : arrBut) {
            switch ((int) (Math.random() * 2)) {
                case 0:
                    switch ((int) (Math.random() * 4)) {
                        case 0:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                            break;
                        case 1:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                            break;
                        case 2:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                            break;
                        case 3:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                            break;
                    }
                    but.setText(rez + ((int) (Math.random() * 10) + 1) + "");
                    break;
                case 1:
                    switch ((int) (Math.random() * 4)) {
                        case 0:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                            break;
                        case 1:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                            break;
                        case 2:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                            break;
                        case 3:
                            but.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                            break;
                    }
                    but.setText(rez - ((int) (Math.random() * 10) + 1) + "");
                    break;
            }
        }
        switch ((int) (Math.random() * 16)) {
            case 0:
                switch (colorAnswer){
                    case 0:but1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but1.setText(rez + "");
                break;
            case 1:
                switch (colorAnswer){
                    case 0:but2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but2.setText(rez + "");
                break;
            case 2:
                switch (colorAnswer){
                    case 0:but3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but3.setText(rez + "");
                break;
            case 3:
                switch (colorAnswer){
                    case 0:but4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;
                }
                but4.setText(rez + "");
                break;
            case 4:
                switch (colorAnswer){
                    case 0:but5.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but5.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but5.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but5.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but5.setText(rez + "");
                break;
            case 5:
                switch (colorAnswer){
                    case 0:but6.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but6.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but6.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but6.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but6.setText(rez + "");
                break;
            case 6:
                switch (colorAnswer){
                    case 0:but7.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but7.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but7.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but7.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but7.setText(rez + "");
                break;
            case 7:
                switch (colorAnswer){
                    case 0:but8.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but8.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but8.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but8.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but8.setText(rez + "");
                break;
            case 8:
                switch (colorAnswer){
                    case 0:but9.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but9.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but9.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but9.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but9.setText(rez + "");
                break;
            case 9:
                switch (colorAnswer){
                    case 0:but10.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but10.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but10.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but10.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but10.setText(rez + "");
                break;
            case 10:
                switch (colorAnswer){
                    case 0:but11.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but11.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but11.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but11.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but11.setText(rez + "");
                break;
            case 11:
                switch (colorAnswer){
                    case 0:but12.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but12.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but12.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but12.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but12.setText(rez + "");
                break;
            case 12:
                switch (colorAnswer){
                    case 0:but13.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but13.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but13.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but13.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but13.setText(rez + "");
                break;
            case 13:
                switch (colorAnswer){
                    case 0:but14.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but14.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but14.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but14.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but14.setText(rez + "");
                break;
            case 14:
                switch (colorAnswer){
                    case 0:but15.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but15.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but15.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but15.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but15.setText(rez + "");
                break;
            case 15:
                switch (colorAnswer){
                    case 0:but16.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                        break;
                    case 1:but16.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange));
                        break;
                    case 2:but16.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPink));
                        break;
                    case 3:but16.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                        break;

                }
                but16.setText(rez + "");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                if (rez == Integer.parseInt(but1.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but2:
                if (rez == Integer.parseInt(but2.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but3:
                if (rez == Integer.parseInt(but3.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but4:
                if (rez == Integer.parseInt(but4.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but5:
                if (rez == Integer.parseInt(but5.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but6:
                if (rez == Integer.parseInt(but6.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but7:
                if (rez == Integer.parseInt(but7.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but8:
                if (rez == Integer.parseInt(but8.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but9:
                if (rez == Integer.parseInt(but9.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but10:
                if (rez == Integer.parseInt(but10.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but11:
                if (rez == Integer.parseInt(but11.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but12:
                if (rez == Integer.parseInt(but12.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but13:
                if (rez == Integer.parseInt(but13.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but14:
                if (rez == Integer.parseInt(but14.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but15:
                if (rez == Integer.parseInt(but15.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.but16:
                if (rez == Integer.parseInt(but16.getText() + "")) {
                    scoreCount();
                    Play();
                } else {
                    lifeCount();
                }
                break;
            case R.id.pause:
                checkPause = true;
                Intent i = new Intent(this, Pause.class);
                i.putExtra("key", String.valueOf(4));
                startActivity(i);
                break;

        }
    }

    protected void scoreCount() {
        Scores += 12 + (int) (Math.random() * 16) + (int) (s / 2);
        score.setText("Очки: " + Scores);
        bonus++;
        if (bonus == 10) {
            bonus = 0;
            lifes++;
            life.setText(" " + lifes);
        }
    }

    protected void lifeCount() {
        lifes--;
        life.setText(" " + lifes);
        bonus = 0;
        if (lifes == 0) {
            Intent i = new Intent(this, GameOver.class);
            i.putExtra("Score", Scores + "");
            i.putExtra("key", 4 + "");
            if (Integer.parseInt(SP.getString(key4, "")) < Scores) {
                SP = getSharedPreferences("save", MODE_PRIVATE);
                SharedPreferences.Editor editor = SP.edit();
                editor.putString(key4, String.valueOf(Scores));
                editor.commit();
            }
            startActivity(i);
            finish();
        }
    }

    protected void update() {
        if (!pause) {
            s -= 0.1;
        }
        if (s < 0.1) {
            lifeCount();
            Play();

        }
        time.setText(String.format("%.1f", s));
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause = true;
        if (lifes != 0 && !checkPause) {
            Intent i = new Intent(this, Pause.class);
            i.putExtra("key", String.valueOf(4));
            startActivity(i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        pause = false;
        checkPause = false;
    }

    class Timer extends CountDownTimer {

        public Timer() {
            super(Integer.MAX_VALUE, 100);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            update();
        }

        @Override
        public void onFinish() {

        }
    }
}
