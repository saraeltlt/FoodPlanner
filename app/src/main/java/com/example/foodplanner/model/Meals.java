package com.example.foodplanner.model;

import android.os.Parcel;

import java.io.Serializable;

public class Meals implements Serializable {
    String strMeal;
    String  strCategory;
    String strMealThumb;
    String strArea;
    String strYoutube;
    String strInstructions;

    public Meals() {
    }

    public Meals(String strMeal, String strCategory, String strMealThumb, String strArea, String strYoutube, String strInstructions) {
        this.strArea =strArea;
        this.strCategory= strCategory;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strMealThumb = strMealThumb;
        this.strYoutube = strYoutube;
    }

    protected Meals(Parcel in) {
        strMeal = in.readString();
        strCategory = in.readString();
        strMealThumb = in.readString();
        strArea = in.readString();
        strYoutube = in.readString();
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

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }
}
