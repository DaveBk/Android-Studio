package com.example.s15720PAMO.BMI;

public class FoodRecommendationService {
    private static float NORMAL_DOWN_VALUE = 17.2f;
    private static float NORMAL_TOP_VALUE = 30.0f;

    public FoodRecommendationService() {

    }

    public String recommendedFood(float bmi) {
        if (bmi < NORMAL_DOWN_VALUE) {
            return "Eat more pizza";
        } else if (NORMAL_DOWN_VALUE < bmi && bmi < NORMAL_TOP_VALUE) {
            return "Eat pizza and vegetables";
        } else {
            return "Eat vegetables";
        }
    }

}
