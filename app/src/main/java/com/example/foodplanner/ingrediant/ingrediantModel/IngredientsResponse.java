package com.example.foodplanner.ingrediant.ingrediantModel;

import java.util.ArrayList;

public class IngredientsResponse {
    private ArrayList<Ingredients> meals;

    public ArrayList<Ingredients> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Ingredients> meals) {
        this.meals = meals;
    }
}
