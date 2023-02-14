package com.example.foodplanner.favorite.favoritePressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.favorite.favoriteView.FavMealInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;

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
        Toast.makeText(context.getApplicationContext(), R.string.remove_fav, Toast.LENGTH_SHORT).show();

    }
}
