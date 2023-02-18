package com.example.foodplanner.firebasePackage;

import android.content.Context;
import android.content.Intent;

import com.example.foodplanner.mealModel.Meal;
import com.google.firebase.auth.FirebaseUser;

public interface FirebaseInterface {
    public void login(String email,String pass);
    public void signup();
    public void googleAuth(Context context);
    public  void addFav(Context context, Meal myMeal);
    public void removeFav(Context context,  Meal myMeal);
    public void addPlan(Context context, Meal myMeal);
    public void removePlan(Context context,  Meal myMeal);
    public void getFav(Context context, FirebaseUser user);
    public void getPlan(Context context, FirebaseUser user,String day);


}
