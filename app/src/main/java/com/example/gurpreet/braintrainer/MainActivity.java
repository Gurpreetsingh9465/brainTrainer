package com.example.gurpreet.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    Random rand;
    Button go;
    TextView correct;
    TextView clock;
    TextView score;
    TextView question;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button again;
    int answere;
    int totalanswere;
    int choice;
    public void play(){
        if(!button1.isEnabled()){
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
        }
        new CountDownTimer(30000+100,1000){
            public void onTick(long milisecondUntilDone){
                clock.setText(milisecondUntilDone/1000 + "s");
            }
            public void onFinish(){
                clock.setText("0s");
                again.setVisibility(View.VISIBLE);
                correct.setVisibility(View.VISIBLE);
                correct.setText("Game Over! "+answere+"/"+totalanswere);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
            }
        }.start();
    }
    public int newLayout(){
        int a = rand.nextInt(50);
        int b = rand.nextInt(51);
        int correctONE = a+b;
        question.setText(a + "+" + b);
        score.setText(answere+"/"+totalanswere);
        int choice = rand.nextInt(4) + 1 ;
        ArrayList array = new ArrayList();
        while(true){
            if(array.size() == 3){
                break;
            }
            int x = rand.nextInt(99);
            if(x!=correctONE){
                array.add(x);
            }
        }
        switch (choice){
            case (1):
                button1.setText(Integer.toString(correctONE));
                button2.setText(""+array.get(0));
                button3.setText(""+array.get(1));
                button4.setText(""+array.get(2));
                break;
            case (2):
                button2.setText(Integer.toString(correctONE));
                button1.setText(""+array.get(0));
                button3.setText(""+array.get(1));
                button4.setText(""+array.get(2));
                break;
            case (3):
                button3.setText(Integer.toString(correctONE));
                button2.setText(""+array.get(0));
                button1.setText(""+array.get(1));
                button4.setText(""+array.get(2));
                break;
            case (4):
                button4.setText(Integer.toString(correctONE));
                button2.setText(""+array.get(0));
                button3.setText(""+array.get(1));
                button1.setText(""+array.get(2));
                break;
        }
        return (choice);
    }


    public void start(View view){
        go.setVisibility(View.INVISIBLE);
        correct.setVisibility(View.INVISIBLE);
        clock.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        again.setVisibility(View.INVISIBLE);
        score.setText("0/0");
        answere = 0;
        totalanswere = 0;
        play();
        choice = newLayout();

    }
    public void mainlogic(View view){
        totalanswere += 1;
        switch (view.getId()){
            case (R.id.button1):
                if(choice == 1){
                    answere += 1;
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Correct!");
                    choice = newLayout();
                }else{
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Wrong!");
                    choice = newLayout();
                }
                break;
            case (R.id.button2):
                if(choice == 2){
                    answere += 1;
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Correct!");
                    choice = newLayout();
                }else{
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Wrong!");
                    choice = newLayout();
                }
                break;
            case (R.id.button3):
                if(choice == 3){
                    answere += 1;
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Correct!");
                    choice = newLayout();
                }else{
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Wrong!");
                    choice = newLayout();
                }
                break;
            case (R.id.button4):
                if(choice == 4){
                    answere += 1;
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Correct!");
                    choice = newLayout();
                }else{
                    correct.setVisibility(View.VISIBLE);
                    correct.setText("Wrong!");
                    choice = newLayout();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button) findViewById(R.id.go);
        correct = (TextView) findViewById(R.id.correct);
        clock = (TextView) findViewById(R.id.clock);
        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        again = (Button) findViewById(R.id.again);
        correct.setVisibility(View.INVISIBLE);
        clock.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        rand = new Random();
    }
}
