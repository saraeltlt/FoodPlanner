package com.example.foodplanner.details.detailsPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.details.detailsView.DetailsInterface;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;

public class DetailsMealPressenter implements DetailsMealPressenterInterface {
    private DetailsInterface view;
    private Repository repo;
    ApiClient client;
    Context context;

    public DetailsMealPressenter(DetailsInterface view, Repository repo, ApiClient client, Context context) {
        this.view = view;
        this.repo = repo;
        this.client = client;
        this.context = context;
    }

    @Override
    public void addToFav(Meal meal) {
        repo.insert(meal);
        Toast.makeText(context.getApplicationContext(), "Added To Favourite", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void deleteMealFromFav(Meal meal) {
        repo.delete(meal);
        Toast.makeText(context.getApplicationContext(), "Removed From Favourite", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void addToPlan(Meal meal) {

    }

}