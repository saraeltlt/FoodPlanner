package com.example.foodplanner.meal.mealPresenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.home.homePressenter.MealPressenterInterface;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.meal.mealView.MealInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SearchMealPresenter implements SearchMealPresenterInterface,NetworkDelegate{
    private MealInterface mealInterface;
    ApiClient client;
    Context context;

    public SearchMealPresenter(MealInterface mealInterface, ApiClient client, Context context) {
        this.mealInterface = mealInterface;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getMeal() {
        client.ObserveMeal(this);
    }

    @Override
    public void onSuccessResultMeal(ArrayList<Meal> meal) {
        mealInterface.showMeal(meal);
    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {

    }

    @Override
    public void onSuccessResultArea(ArrayList<Area> areas) {

    }

    @Override
    public void onSuccessResultCategory(ArrayList<Category> categories) {

    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
    }
}




