package com.example.foodplanner.plan.planPressenter;

import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.home.homeView.HomeInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.plan.planView.PlanInterface;

public class PlanPressenter implements PlanPressenterInterface {
    private PlanInterface view;
    private Repository repo;
    Context context;

    public PlanPressenter(PlanInterface view, Repository repo, Context context) {
        this.view = view;
        this.repo = repo;
        this.context = context;
    }

    @Override
    public void getMeal(String day) {
        view.showPlan(repo.getMealsPlan(day));

    }


    @Override
    public void deleteMeal(Meal meal) {
        repo.delete(meal);
        getMeal(meal.getDay());
        Toast.makeText(context.getApplicationContext(), R.string.remove_plan, Toast.LENGTH_SHORT).show();
    }
}
