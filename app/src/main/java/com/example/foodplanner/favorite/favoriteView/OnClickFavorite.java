package com.example.foodplanner.favorite.favoriteView;


import com.example.foodplanner.model.Meal;

public interface OnClickFavorite {
    void onClickDetails(Meal meal);
    void onClickRemoveFav(Meal meal);

}
