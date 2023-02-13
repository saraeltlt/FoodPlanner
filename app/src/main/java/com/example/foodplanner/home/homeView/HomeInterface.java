package com.example.foodplanner.home.homeView;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public interface HomeInterface {
    public void showMeal (List<Meal> meal);
    public void addMeal(Meal meal);
    public void deleteMeal(Meal meal);
}
