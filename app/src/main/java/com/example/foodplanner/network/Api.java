package com.example.foodplanner.network;

import io.reactivex.Observable;

import com.example.foodplanner.area.areaModel.AreaResponse;
import com.example.foodplanner.category.categoryModel.CategoryResponse;
import com.example.foodplanner.ingrediant.ingrediantModel.IngredientsResponse;
import com.example.foodplanner.mealModel.MealsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search.php?s")
    public Observable<MealsResponse> getRandomMeals();
    @GET("categories.php")
    public Observable<CategoryResponse>getCategories();
    @GET("list.php?i=list")
    public Observable<IngredientsResponse>getIngredients();

    @GET("list.php?a=list")
    public Observable<AreaResponse>getArea();

    @GET("categories.php")
    public Observable<CategoryResponse>getCategory();

    @GET("filter.php")
    public Observable<MealsResponse>searchByCategory(@Query("c") String c);
    @GET("filter.php")
    public Observable<MealsResponse>searchByIngredient(@Query("i") String i);


    @GET("search.php")
    public Observable<MealsResponse>getDetailedMeal(@Query("s") String s);

}
