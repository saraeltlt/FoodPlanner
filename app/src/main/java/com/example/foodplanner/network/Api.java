package com.example.foodplanner.network;

import io.reactivex.Observable;

import com.example.foodplanner.model.RandomMeals;

import retrofit2.http.GET;

public interface Api {
    @GET("search.php?s")
    public Observable<RandomMeals> getRandomMeals();
/*
    @GET("list.php?i=list")
    public Observable<>getIngredients();
    /*
    @GET
    public Observable<>getAreas();
    @GET
    public Observable<>getCategories();
    @GET
    public Observable<>searchByIngredients();
    @GET
    public Observable<>searchByArea();
    @GET
    public Observable<>searchByCategory();
    @GET
    public Observable<>searchByMealName();
    */

}
