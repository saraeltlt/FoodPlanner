package com.example.foodplanner.plan.planPressenter;

import com.example.foodplanner.mealModel.Meal;

public interface PlanPressenterInterface {
    public void getMeal(String day);

    public void deleteMeal(Meal meal);
}
