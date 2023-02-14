package com.example.foodplanner.details.detailsView;
import com.example.foodplanner.mealModel.Meal;

public interface DetailsInterface {
    public void addMealToFav(Meal meal);
    public void deleteMealFromFav(Meal meal);
    public void addMealToPlan(Meal meal, String day);

}
