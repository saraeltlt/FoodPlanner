package com.example.foodplanner.network;

import io.reactivex.Observable;

import com.example.foodplanner.model.AreaResponse;
import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.CategoryResponse;
import com.example.foodplanner.model.IngredientsResponse;
import com.example.foodplanner.model.RandomMealsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search.php?s")
    public Observable<RandomMealsResponse> getRandomMeals();
    @GET("categories.php")
    public Observable<CategoryResponse>getCategories();
    @GET("list.php?i=list")
    public Observable<IngredientsResponse>getIngredients();
    /*@GET("list.php")
    public Observable<IngredientsResponse>getIngredients(@Query("i") String ingredient);  //?i=list*/

    /* @GET
    public Observable<AreaResponse>getAreas(@Query("a") String area);  //?a=list);
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
