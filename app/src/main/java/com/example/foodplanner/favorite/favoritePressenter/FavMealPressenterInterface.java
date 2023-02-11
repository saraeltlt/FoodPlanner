package com.example.foodplanner.favorite.favoritePressenter;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FavMealPressenterInterface {
    public void  getMeals();
    public void deleteMeal(Meal meal);
}
