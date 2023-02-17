package com.example.foodplanner.favorite.favoritePressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.favorite.favoriteView.FavMealInterface;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.google.firebase.auth.FirebaseAuth;

public class FavMealPressenter implements FavMealPressenterInterface{
    private FavMealInterface view;
    
    private Repository repo;
    Context context;
    FirebaseAuth firebaseAuth ;
    FirebaseUtil firebaseUtil;

    public FavMealPressenter(FavMealInterface view, Repository repo, Context context)
    {
        this.repo=repo;
        this.view=view;
        this.context=context;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUtil = new FirebaseUtil();

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
        firebaseUtil.removeFav(context,meal);

    }
}
