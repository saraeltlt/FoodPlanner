package com.example.foodplanner.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.model.Meal;

@Database(entities = {Meal.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance = null;
    public abstract MealDAO mealDAO();
    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "mealdb")
                    .build(); }
        return instance; }
}
