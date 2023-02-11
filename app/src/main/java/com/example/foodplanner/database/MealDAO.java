package com.example.foodplanner.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.model.Meal;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface MealDAO {
    @Query("SELECT * From meals")
    Observable<List<Meal>> getMeals();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal (Meal meal);
    @Delete
    Completable deleteMeal (Meal meal);
}
