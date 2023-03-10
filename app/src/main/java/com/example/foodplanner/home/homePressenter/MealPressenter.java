package com.example.foodplanner.home.homePressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.authentication.authView.LoginFragment;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MealPressenter implements MealPressenterInterface, NetworkDelegate {
    private HomeInterface view;
    private Repository repo;
    FirebaseAuth firebaseAuth ;
    FirebaseUtil firebaseUtil;
    ApiClient client;
    Context context;

    public MealPressenter(HomeInterface view, Repository repo, ApiClient client, Context context) {
        this.view = view;
        this.repo = repo;
        this.client = client;
        this.context = context;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUtil = new FirebaseUtil();
    }

    @Override
    public void getMeal() {
        client.ObserveMeal(this);

    }

    @Override
    public void addToFav(Meal meal) {
        repo.insert(meal);
        Toast.makeText(context.getApplicationContext(), R.string.add_fav, Toast.LENGTH_SHORT).show();
        firebaseUtil.addFav(context,meal);

    }

    @Override
    public void deleteMeal(Meal meal) {
        repo.delete(meal);
        Toast.makeText(context.getApplicationContext(), R.string.remove_fav, Toast.LENGTH_SHORT).show();
        firebaseUtil.removeFav(context,meal);
    }

    @Override
    public void onSuccessResultMeal(ArrayList<Meal> meals) {
        view.showMeal(getRandomMeals(meals));

    }

    @Override
    public void onSuccessResultDetailedMeal(ArrayList<Meal> meal) {

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
    public List<Meal> getRandomMeals(List<Meal> meals){
        List<Meal> randomMeals= new ArrayList<>();
        ThreadLocalRandom.current().ints(0, 23).distinct().limit(5).forEach(i->
                randomMeals.add(meals.get(i))
        );
        return randomMeals;
    }
}
