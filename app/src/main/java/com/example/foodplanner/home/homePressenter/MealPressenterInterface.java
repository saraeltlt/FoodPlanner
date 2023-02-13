package com.example.foodplanner.home.homePressenter;

import com.example.foodplanner.mealModel.Meal;

public interface MealPressenterInterface {
    public void getMeal();
    public void addToFav(Meal meal);
    public void deleteMeal(Meal meal);
}
