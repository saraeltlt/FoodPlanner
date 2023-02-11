package com.example.foodplanner.favorite.favoriteView;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FavMealInterface {
    public void showFavData (List<Meal> meal);
    public void deleteMeal(Meal meal);
}
