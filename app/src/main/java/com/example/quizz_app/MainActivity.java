package com.example.quizz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ScrollView scroll;
    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;

    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question7;
    private CheckBox wrongAnswerEight;
    private EditText question5;

    private CheckBox question8_1;
    private CheckBox question8_2;
    private CheckBox question8_4;

    private int correctAnswers = 0;
    private int wrongAnswers = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = (ScrollView) findViewById(R.id.Scroll);


        question1 = (RadioButton) findViewById(R.id.rb_CorrectAnswerOne);
        question2 = (RadioButton) findViewById(R.id.rb_CorrectAnswerTwo);
        question3 = (RadioButton) findViewById(R.id.rb_CorrectAnswerThree);
        question4 = (RadioButton) findViewById(R.id.rb_CorrectAnswerFour);
        question5 = (EditText) findViewById(R.id.userResponse_AnswerFive);
        wrongAnswerEight = (CheckBox) findViewById(R.id.cb_WrongAnswerEight);
        question8_1 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_1);
        question8_2 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_2);
        question8_4 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_3);
        radioGroupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        radioGroupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        radioGroupFour = (RadioGroup) findViewById(R.id.radioGroupFour);










    }


    public void SubmitResponse(View v) {


        String answerFive = getResources().getString(R.string.AnswerFive);

        String allCorrect = getResources().getString(R.string.allCorrect);
        String allFailed = getResources().getString(R.string.allFailed);


        if (question1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }
        if (question2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }
        if (question3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        if (question4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }


        if (answerFive.equals(question5.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        if (question8_1.isChecked() && question8_2.isChecked() && question8_4.isChecked() && !(wrongAnswerEight.isChecked())) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        if (correctAnswers == 6) {
            Toast.makeText(this, allCorrect , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + "\n" + "Wrong answers: " + wrongAnswers, Toast.LENGTH_LONG).show();
        }


        if(wrongAnswers == 6 ) {
            Toast.makeText(this, allFailed, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + "\n" + "Wrong answers: " + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        ResetQuiz(findViewById(R.id.all));


    }

    public void ResetQuiz(View v) {

        correctAnswers = 0;
        wrongAnswers = 0;



        question5.getText().clear();

        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();



        if (question8_1.isChecked()) {
            question8_1.toggle();
        }

        if (question8_2.isChecked()) {
            question8_2.toggle();
        }

        if (question8_4.isChecked()) {
            question8_4.toggle();
        }

        if (wrongAnswerEight.isChecked()) {
            wrongAnswerEight.toggle();
        }


        scroll.fullScroll(ScrollView.FOCUS_UP);


    }






}
