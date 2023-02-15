package com.example.foodplanner.searchResult.searchResultPressenter;

public interface SearchResultPressenterInterface {
    public void getMeal(String category);
    public void getMealByIngredient(String ingredient);
    public void getDeatiledMeal(String meal);
    public void getMealByArea(String area);


}
