package com.example.foodplanner.searchResult.searchResultView;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public interface SearchResultInterface {
    public void showMeal (List<Meal> meal);
    public void  passMealDetails(List<Meal> meal);
}
