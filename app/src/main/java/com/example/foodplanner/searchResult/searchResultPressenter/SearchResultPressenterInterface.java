package com.example.foodplanner.searchResult.searchResultPressenter;

import com.example.foodplanner.mealModel.Meal;

public interface SearchResultPressenterInterface {
    public void getMeal(String category);
    public void getMealByIngredient(String ingredient);
    public void getDeatiledMeal(String meal);

}
