package com.example.foodplanner.model;

public class Meals {
    String strMeal;
    String  strCategory;
    String strMealThumb;
    String strArea;
    String strSource;

    public Meals() {
    }

    public Meals(String strMeal, String strCategory, String strMealThumb, String strArea, String strSource) {
        this.strArea =strArea;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strMealThumb = strMealThumb;
        this.strSource = strSource;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }
}
