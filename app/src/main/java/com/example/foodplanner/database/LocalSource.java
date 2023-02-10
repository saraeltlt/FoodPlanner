package com.example.foodplanner.database;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface LocalSource {
    public List<Meal> getFavoriteMeals();
    public void delete(Meal meal);
    public void insert(Meal meal);
}
