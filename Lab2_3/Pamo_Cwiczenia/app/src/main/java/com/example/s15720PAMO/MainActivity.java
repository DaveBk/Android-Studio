package com.example.s15720PAMO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.s15720PAMO.BMI.BmiCalculator;
import com.example.s15720PAMO.Chart.ChartMenuActivity;
import com.example.s15720PAMO.Quiz.QuizActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonBmi;
    private Button buttonQuiz;
    private Button buttonCovid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBmi = findViewById(R.id.buttonBmi);
        buttonBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalcActivity();
            }
        });

        buttonQuiz = findViewById(R.id.buttonQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });

        buttonCovid = findViewById(R.id.buttonCovid);
        buttonCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChartActivity();
            }
        });
    }

    public void openCalcActivity() {
        Intent intent = new Intent(this, BmiCalculator.class);
        startActivity(intent);
    }

    public void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void openChartActivity() {
        Intent intent = new Intent(this, ChartMenuActivity.class);
        startActivity(intent);
    }


}
