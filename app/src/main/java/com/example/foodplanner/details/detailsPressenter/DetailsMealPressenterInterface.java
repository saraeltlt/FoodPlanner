package com.example.foodplanner.details.detailsPressenter;

import com.example.foodplanner.mealModel.Meal;

public interface DetailsMealPressenterInterface {
    public void addToFav(Meal meal);
    public void deleteMealFromFav(Meal meal);
    public void addToPlan(Meal meal, String day);

}
