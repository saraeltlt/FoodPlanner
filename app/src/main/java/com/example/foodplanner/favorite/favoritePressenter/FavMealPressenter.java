package com.example.foodplanner.favorite.favoritePressenter;

import android.content.Context;

import com.example.foodplanner.favorite.favoriteView.FavMealInterface;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;

import java.util.ArrayList;
import java.util.List;

public class FavMealPressenter implements FavMealPressenterInterface{
    private FavMealInterface view;
    
    private Repository repo;
    Context context;
    public FavMealPressenter(FavMealInterface view, Repository repo, Context context)
    {
        this.repo=repo;
        this.view=view;
        this.context=context;

    }

    @Override
    public void getMeals() {
        view.showFavData(repo.getFavoriteMeals());

    }

    @Override
    public void deleteMeal(Meal meal) {
        repo.delete(meal);
        getMeals();

    }
}
