package com.example.foodplanner.network;

import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.mealModel.Meal;
import java.util.ArrayList;

public interface NetworkDelegate {
    public void onSuccessResultMeal(ArrayList<Meal> meal);
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients);
    public void onSuccessResultArea(ArrayList<Area> areas);
    public void onSuccessResultCategory(ArrayList<Category> categories);
    public void onFailureResult(String errormMsg);
}
