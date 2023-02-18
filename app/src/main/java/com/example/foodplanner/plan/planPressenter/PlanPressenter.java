package com.example.foodplanner.plan.planPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.plan.planView.PlanInterface;
import com.google.firebase.auth.FirebaseAuth;

public class PlanPressenter implements PlanPressenterInterface {
    private PlanInterface view;
    private Repository repo;
    Context context;
    FirebaseAuth firebaseAuth ;
    FirebaseUtil firebaseUtil;

    public PlanPressenter(PlanInterface view, Repository repo, Context context) {
        this.view = view;
        this.repo = repo;
        this.context = context;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUtil = new FirebaseUtil();
    }

    @Override
    public void getMeal(String day) {
        view.showPlan(repo.getMealsPlan(day));

    }


    @Override
    public void deleteMeal(Meal meal) {
        repo.delete(meal);
        Toast.makeText(context.getApplicationContext(), R.string.remove_plan, Toast.LENGTH_SHORT).show();
        firebaseUtil.removePlan(context,meal);
        getMeal(meal.getDay());
    }
}
