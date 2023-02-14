package com.example.foodplanner.details.detailsPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.details.detailsView.DetailsInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
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
        Toast.makeText(context.getApplicationContext(), R.string.add_fav, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void deleteMealFromFav(Meal meal) {
        repo.delete(meal);
        Toast.makeText(context.getApplicationContext(), R.string.remove_fav, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void addToPlan(Meal meal, String day) {

    }

}
