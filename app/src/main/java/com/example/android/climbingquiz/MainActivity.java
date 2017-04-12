package com.example.android.climbingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Declare score variable
     * */
    int score;

    /**
     * onClick for submit button, calculates the score.
     * */
    public void submit(View view){
        score = pointsAnswerOne();
        score += pointsAnswerTwo();
        score += pointsAnswerThree();
        score += pointsAnswerFour();
        score += pointsAnswerFive();

        Toast.makeText(this, "You scored " + score +"/5", Toast.LENGTH_SHORT).show();
    }

    /**
     * Methods that check if the answers are correct
     * */
    private int pointsAnswerOne(){
        boolean correct = ((RadioButton) findViewById(R.id.climb1a)).isChecked();
        int points = correct ? 1 : 0;
        return points;
    }

    private int pointsAnswerTwo(){
        boolean correctA = ((CheckBox) findViewById(R.id.climb2a)).isChecked();
        boolean correctB = ((CheckBox) findViewById(R.id.climb2b)).isChecked();
        boolean correctC = ((CheckBox) findViewById(R.id.climb2c)).isChecked();
        boolean correctD = ((CheckBox) findViewById(R.id.climb2d)).isChecked();

        int points = (correctA && (!correctB) && correctC && (!correctD)) ? 1 : 0;
        return points;
    }

    private int pointsAnswerThree(){
        boolean correct = ((RadioButton) findViewById(R.id.climb3d)).isChecked();
        int points = correct ? 1 : 0;
        return points;
    }

    private int pointsAnswerFour(){
        boolean correct = ((RadioButton) findViewById(R.id.climb4b)).isChecked();
        int points = correct ? 1 : 0;
        return points;
    }

    private int pointsAnswerFive(){
        EditText editText = (EditText) findViewById(R.id.climb5_field);
        String input = editText.getText().toString().toLowerCase().trim();
        String answer = "megos";
        int points = input.equals(answer) ? 1 : 0;
        return points;
    }
}
