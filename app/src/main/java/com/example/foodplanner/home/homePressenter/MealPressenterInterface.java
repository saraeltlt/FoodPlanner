package com.example.foodplanner.home.homePressenter;

import com.example.foodplanner.model.Meal;

public interface MealPressenterInterface {
    public void getMeal();
    public void addToFav(Meal meal);
}
