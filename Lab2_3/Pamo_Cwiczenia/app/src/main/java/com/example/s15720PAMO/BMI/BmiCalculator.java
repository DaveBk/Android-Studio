package com.example.s15720PAMO.BMI;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.s15720PAMO.R;

public class BmiCalculator extends AppCompatActivity {

    private FoodRecommendationService foodRecommendationService;
    private EditText height;
    private EditText weight;
    private EditText age;
    private TextView resultBmi;
    private TextView resultFood;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
 


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);
        resultBmi = findViewById(R.id.resultBmi);
        resultFood = findViewById(R.id.resultFood);

    }


    public void calculateBMI(View v) {

        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String ageStr = age.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {

            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            String sex = addListenerOnButton();
            float bhc = calculateBHC(heightStr, weightStr, ageStr, sex);

            displayBMI(bmi, bhc);

        }
    }

    private float calculateBHC(String heightStr, String weightStr, String ageStr, String sex) {
        float heightValue = Float.parseFloat(heightStr);
        float weightValue = Float.parseFloat(weightStr);
        float ageValue = Float.parseFloat(ageStr);
        float result = 0;



        if(sex.equals(getString(R.string.female))) {
            result = 655.1f + (9.563f * weightValue) + (1.85f * heightValue) - (4.676f * ageValue);
        }else if(sex.equals(getString(R.string.male))) {
            result = 66.5f + (13.75f * weightValue) + (5.003f * heightValue) - (6.775f * ageValue);
        }

        return result;
    }

    private void displayBMI(float bmi, float bhc) {
        String bmiLabel = "";
        foodRecommendationService = new FoodRecommendationService();

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.wyglodzenie);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.wychudzenie);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.niedowaga);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.wartosc_prawidlowa);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.nadwaga);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.I_stopien_otylosci);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.II_stopien_otylosci);
        } else {
            bmiLabel = getString(R.string.otyłosc_skrajna);
        }

        bmiLabel ="BMI = " + bmi + ": " + bmiLabel + "\n\n" + "Calories per day " + bhc;


        resultBmi.setText(bmiLabel);
        resultFood.setText(foodRecommendationService.recommendedFood(bmi));
    }


    public String addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);


        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioSexButton = (RadioButton) findViewById(selectedId);

        return radioSexButton.getText().toString();

    }


}
