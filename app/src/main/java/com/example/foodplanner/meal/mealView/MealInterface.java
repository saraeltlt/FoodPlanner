package com.example.foodplanner.meal.mealView;

import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public interface MealInterface {
    public void showMeal (List<Meal> meal);
    public void searchMeal(List<Meal> meal);
}
