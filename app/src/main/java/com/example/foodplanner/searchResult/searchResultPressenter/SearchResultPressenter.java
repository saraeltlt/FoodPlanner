package com.example.foodplanner.searchResult.searchResultPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;
import com.example.foodplanner.searchResult.searchResultView.SearchResultInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SearchResultPressenter implements SearchResultPressenterInterface, NetworkDelegate {
    private SearchResultInterface view;
    private Repository repo;
    ApiClient client;
    Context context;

    public SearchResultPressenter(SearchResultInterface view, Repository repo, ApiClient client, Context context) {
        this.view = view;
        this.repo = repo;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getMeal(String category) {
        client.searchByCategories(this,category);
    }
    @Override
    public void getMealByArea(String area) {
        client.searchByArea(this,area);
    }

   @Override
    public void getDeatiledMeal(String meal) {
        client.getDetailedMeal(this,meal);

    }

    @Override
    public void onSuccessResultMeal(ArrayList<Meal> meals) {
        view.showMeal(meals);

    }

    @Override
    public void onSuccessResultDetailedMeal(ArrayList<Meal> meal) {

        view.passMealDetails(meal);
    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {
        //nothing
    }

    @Override
    public void onSuccessResultArea(ArrayList<Area> ingredients) {

    }

    @Override
    public void onSuccessResultCategory(ArrayList<Category> categories) {

    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
    }
}
