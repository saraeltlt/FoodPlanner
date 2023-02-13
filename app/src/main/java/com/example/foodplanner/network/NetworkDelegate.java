package com.example.foodplanner.network;

import com.example.foodplanner.model.Area;
import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Ingredients;
import com.example.foodplanner.model.Meal;

import java.util.ArrayList;

public interface NetworkDelegate {
    public void onSuccessResult(ArrayList<Meal> meal);
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients);
    public void onSuccessResultArea(ArrayList<Area> areas);
    public void onSuccessResultCategory(ArrayList<Category> categories);



    public void onFailureResult(String errormMsg);
}
