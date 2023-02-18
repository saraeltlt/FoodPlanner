package com.example.foodplanner.details.detailsPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.details.detailsView.DetailsInterface;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class DetailsMealPressenter implements DetailsMealPressenterInterface {
    private DetailsInterface view;
    private Repository repo;
    ApiClient client;
    Context context;
    FirebaseAuth firebaseAuth ;
    FirebaseUtil firebaseUtil;
    public DetailsMealPressenter(DetailsInterface view, Repository repo, ApiClient client, Context context) {
        this.view = view;
        this.repo = repo;
        this.client = client;
        this.context = context;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUtil = new FirebaseUtil();
    }

    @Override
    public void addToFav(Meal meal) {
        repo.insert(meal);
        Toast.makeText(context.getApplicationContext(), R.string.add_fav, Toast.LENGTH_SHORT).show();
        firebaseUtil.addFav(context,meal);

    }

    @Override
    public void addToPlan(Meal meal) {
        repo.insert(meal);
        firebaseUtil.addPlan(context,meal);

    }
    @Override
    public void deleteMealFromFav(Meal meal) {
        repo.delete(meal);
        Toast.makeText(context.getApplicationContext(), R.string.remove_fav, Toast.LENGTH_SHORT).show();
        firebaseUtil.removeFav(context,meal);

    }




}
