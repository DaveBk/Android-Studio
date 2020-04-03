package com.example.s15720PAMO.Chart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.s15720PAMO.Chart.Charts.RecoveriesChartActivity;
import com.example.s15720PAMO.Chart.Charts.DeathChartActivity;
import com.example.s15720PAMO.Chart.Charts.InfectedChartActivity;
import com.example.s15720PAMO.R;

public class ChartMenuActivity extends AppCompatActivity {

    private Button buttonInfected;
    private Button buttonCure;
    private Button buttonDeath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chart);

        buttonInfected = findViewById(R.id.button_infected_chart);
        buttonInfected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfectedActivity();
            }
        });

        buttonCure = findViewById(R.id.button_cure_chart);
        buttonCure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCureActivity();
            }
        });

        buttonDeath = findViewById(R.id.button_death_chart);
        buttonDeath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeathActivity();
            }
        });

    }

    public void openInfectedActivity() {
        Intent intent = new Intent(this, InfectedChartActivity.class);
        startActivity(intent);
    }

    public void openCureActivity() {
        Intent intent = new Intent(this, RecoveriesChartActivity.class);
        startActivity(intent);
    }

    public void openDeathActivity() {
        Intent intent = new Intent(this, DeathChartActivity.class);
        startActivity(intent);
    }

}