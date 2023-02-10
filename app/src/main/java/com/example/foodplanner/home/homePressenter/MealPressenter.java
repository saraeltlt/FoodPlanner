package com.example.foodplanner.home.homePressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;

public class MealPressenter implements MealPressenterInterface, NetworkDelegate {
    private HomeInterface view;
    private Repository repo;
    ApiClient client;
    Context context;

    public MealPressenter(HomeInterface view, Repository repo, ApiClient client, Context context) {
        this.view = view;
        this.repo = repo;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getMeal() {
        client.ObserveMeal(this);

    }

    @Override
    public void addToFav(Meal meal) {
        repo.insert(meal);

    }

    @Override
    public void onSuccessResult(ArrayList<Meal> meals) {
        view.showMeal(meals);

    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
    }
}
