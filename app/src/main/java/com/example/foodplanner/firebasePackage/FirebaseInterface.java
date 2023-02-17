package com.example.foodplanner.firebasePackage;

import android.content.Context;

import com.example.foodplanner.mealModel.Meal;

public interface FirebaseInterface {
    public void login(String email,String pass);
    public void signup();
    public void googleAuth(Context context);
    public  void addFav(Context context, Meal myMeal);
    public void removeFav(Context context,  Meal myMeal);
    public void addPlan(Context context, Meal myMeal);
    public void removePlan(Context context,  Meal myMeal);
    public void getFav();
    public void getPlan();
// authPressenterInterface.checkSignGoogle(MainActivity.this);
    //public void Done(){
    //        startActivity(new Intent(MainActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    //    }
}
