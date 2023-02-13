package com.example.foodplanner.favorite.favoriteView;

import com.example.foodplanner.model.Meal;

import java.util.List;

import io.reactivex.Observable;

public interface FavMealInterface {
    public void showFavData (Observable<List<Meal>> meal);
    public void deleteMeal(Meal meal);
}
