package com.example.mathquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int scoreCount = 0;
    int counter = 0;
    String response;
    EditText user_Input;
    TextView Questions;
    TextView math_quiz;


    LinearLayout linearLayout, edittext_layout;
    RadioGroup radioGroup;
    CheckBox cbOption_1, cbOption_2, cbOption_3, cbOption_4;
    RadioButton option_1, option_2, option_3, option_4;
    Button submit;
    Button next;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questions = (TextView) findViewById(R.id.mathQuestion);
        option_1 = (RadioButton) findViewById(R.id.option1);
        option_2 = (RadioButton) findViewById(R.id.option2);
        option_3 = (RadioButton) findViewById(R.id.option3);
        option_4 = (RadioButton) findViewById(R.id.option4);
        submit = (Button) findViewById(R.id.btnSubmit);
        next = (Button) findViewById(R.id.btnNext);
        previous = (Button) findViewById(R.id.btnPrevious);
        radioGroup = (RadioGroup) findViewById(R.id.rgOptions);
        linearLayout = (LinearLayout) findViewById(R.id.checkBox);
        edittext_layout = (LinearLayout) findViewById(R.id.textBox);
        cbOption_1 = (CheckBox) findViewById(R.id.cbOption1);
        cbOption_2 = (CheckBox) findViewById(R.id.cbOption2);
        cbOption_3 = (CheckBox) findViewById(R.id.cbOption3);
        cbOption_4 = (CheckBox) findViewById(R.id.cbOption4);
        user_Input = (EditText) findViewById(R.id.etResponse);
        math_quiz = (TextView) findViewById(R.id.math_Quiz);

        submit.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                if (counter == 0) {
                    if (option_3.isChecked()) {
                        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                        scoreCount++;
                    }
                    else {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }

                }
                if (counter == 1) {
                    if (option_2.isChecked()) {
                        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                        scoreCount++;
                    }
                    else{
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                }
                if (counter == 2) {
                    if (option_1.isChecked()) {
                        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                        scoreCount++;
                    }
                    else {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                }
                if (counter == 3) {
                    if (option_1.isChecked() || option_2.isChecked()) {
                        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                        scoreCount++;
                    }
                    if (option_1.isChecked() || option_2.isChecked()||option_4.isChecked()||option_3.isChecked()){
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                    if (option_1.isChecked() || option_2.isChecked()||option_3.isChecked()){
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                    if (option_1.isChecked() || option_2.isChecked()||option_4.isChecked()){
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                    else {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        submit.setVisibility(View.INVISIBLE);
                    }
                }
                if (counter == 4) {
                    response = user_Input.getText().toString().trim();
                    if (response.equals("4")) {
                        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                        edittext_layout.setVisibility(View.GONE);
                        previous.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                        Questions.setVisibility(View.INVISIBLE);
                        scoreCount++;
                        Toast.makeText(this, "Your score: "+ scoreCount, Toast.LENGTH_SHORT).show();
                        math_quiz.setText("You got " + scoreCount + " Out of 5");
                    } else {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                        edittext_layout.setVisibility(View.GONE);
                        previous.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                        Toast.makeText(this, "Your score: "+ scoreCount, Toast.LENGTH_SHORT).show();
                        math_quiz.setText("You got " + scoreCount + " Out of 5");
                    }
                } else {
                    submit.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btnNext:
                counter++;
                previous.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                if (counter == 1) {
                    Questions.setText("Q.2 Solve the Following math equation using BODMAS : (4-2)*6");
                    option_1.setText("10");
                    option_2.setText("12");
                    option_3.setText("0");
                    option_4.setText("16");
                }

                if (counter == 2) {
                    Questions.setText("Q.3 Solve the following math equation and select single Correct Answere : 4+5+20 =");
                    option_1.setText("29");
                    option_2.setText("10");
                    option_3.setText("1910");
                    option_4.setText("00");
                }
                if (counter == 3) {
                    radioGroup.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                    Questions.setText("Q.4 Among the number listed in the below option which are less than 10");
                    cbOption_1.setText("3");
                    cbOption_2.setText("-5");
                    cbOption_3.setText("15");
                    cbOption_4.setText("22");

                }
                if (counter == 4) {
                    next.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.GONE);
                    edittext_layout.setVisibility(View.VISIBLE);
                    Questions.setText("Q.5 Solve the following eqaution and write down the solution in digits .equation : 10/5+2");

                }
                break;
            case R.id.btnPrevious:
                counter--;
                if (counter == 0) {
                    previous.setVisibility(View.INVISIBLE);
                    Questions.setText("Q.1 Solve the following math equation and select single Correct Answere : 4+5+10 =");
                    option_1.setText("4");
                    option_2.setText("10");
                    option_3.setText("19");
                    option_4.setText("15");
                    scoreCount--;
                }
                if (counter == 1) {
                    previous.setVisibility(View.VISIBLE);
                    Questions.setText("Q.2 Solve the Following math equation using BODMAS : (4-2)*6");
                    option_1.setText("10");
                    option_2.setText("12");
                    option_3.setText("0");
                    option_4.setText("16");
                    scoreCount--;
                }
                if (counter == 2) {
                    previous.setVisibility(View.VISIBLE);
                    Questions.setText("Q.3 Solve the following math equation and select single Correct Answere : 4+5+20 =");
                    option_1.setText("29");
                    option_2.setText("10");
                    option_3.setText("1910");
                    option_4.setText("00");
                    scoreCount--;
                }
                if (counter == 3) {
                    previous.setVisibility(View.VISIBLE);
                    Questions.setText("Q.4 Among the numbers listed  below in options which are less than 10");
                    cbOption_1.setText("3");
                    cbOption_2.setText("-5");
                    cbOption_3.setText("15");
                    cbOption_4.setText("22");
                    scoreCount--;
                }

                break;
        }
    }

}
