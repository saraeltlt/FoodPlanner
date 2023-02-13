package com.example.foodplanner.database;

import com.example.foodplanner.model.Meal;

import java.util.List;

import io.reactivex.Observable;

public interface LocalSource {
    public Observable<List<Meal>> getFavoriteMeals();
    public void delete(Meal meal);
    public void insert(Meal meal);
}
