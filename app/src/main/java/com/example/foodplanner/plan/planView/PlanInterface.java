package com.example.foodplanner.plan.planView;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

import io.reactivex.Observable;

public interface PlanInterface {
    public void showPlan (Observable<List<Meal>> meal);
    public void deleteMeal(Meal meal);

}
