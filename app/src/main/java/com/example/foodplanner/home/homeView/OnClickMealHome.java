
package com.example.foodplanner.home.homeView;
import com.example.foodplanner.model.Meal;

public interface OnClickMealHome {
    void onClickDetails(Meal meal);
    void onClickAddFav(Meal meal);
    void onClickRemoveFav(Meal meal);
}
