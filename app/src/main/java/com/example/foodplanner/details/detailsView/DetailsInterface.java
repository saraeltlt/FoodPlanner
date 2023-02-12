package com.example.foodplanner.details.detailsView;
import com.example.foodplanner.model.Meal;

import java.util.List;

public interface DetailsInterface {
    public void addMealToFav(Meal meal);
    public void deleteMealFromFav(Meal meal);
    public void addMealToPlan(Meal meal);

}
