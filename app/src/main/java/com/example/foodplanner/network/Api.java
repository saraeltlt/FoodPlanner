package com.example.foodplanner.network;

import io.reactivex.Observable;

import com.example.foodplanner.area.areaModel.AreaResponse;
import com.example.foodplanner.category.categoryModel.CategoryResponse;
import com.example.foodplanner.ingrediant.ingrediantModel.IngredientsResponse;
import com.example.foodplanner.mealModel.MealsRandomResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search.php?s")
    public Observable<MealsRandomResponse> getRandomMeals();
    @GET("categories.php")
    public Observable<CategoryResponse>getCategories();
    @GET("list.php?i=list")
    public Observable<IngredientsResponse>getIngredients();

    @GET("list.php?a=list")
    public Observable<AreaResponse>getArea();

    @GET("categories.php")
    public Observable<CategoryResponse>getCategory();


    @GET("filter.php")
    public Observable<IngredientsResponse>searchByIngred(@Query("i") String i);

   /* @GET("list.php")
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
