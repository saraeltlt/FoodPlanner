package com.example.foodplanner.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.mealModel.Meal;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface MealDAO {
    @Query("SELECT * From meals WHERE day IS Null")
    Observable<List<Meal>> getMeals();
    @Query("SELECT * From meals WHERE day LIKE:day")
    Observable<List<Meal>> getPlanMeals(String day);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal (Meal meal);
    @Delete
    Completable deleteMeal (Meal meal);

}
