package com.example.foodplanner.mealModel;

import java.util.ArrayList;

public class MealsResponse {
   private ArrayList<Meal> meals ;

   public ArrayList<Meal> getMeals() {
      return meals;
   }

   public void setMeals(ArrayList<Meal> meals) {
      this.meals = meals;
   }
}
