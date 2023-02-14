
package com.example.foodplanner.plan.planView;
import com.example.foodplanner.mealModel.Meal;

public interface OnClickPlan {
    void onClickDetails(Meal meal);
    void onClickRemove(Meal meal);
}
