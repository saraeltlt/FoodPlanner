package com.example.foodplanner.database;

import android.content.Context;

import com.example.foodplanner.model.Meal;

import java.util.List;

public class ConcreteLocalSource implements LocalSource {
    private Context context;
    private static ConcreteLocalSource instance = null;
    public static ConcreteLocalSource getInstance(Context context){
        if(instance ==null){
            instance = new ConcreteLocalSource(context);
        }
        return instance;
    }
    private ConcreteLocalSource(Context context){
        this.context=context;
    }
    @Override
    public List<Meal> getFavoriteMeals() {
        return null;
    }

    @Override
    public void delete(Meal meal) {

    }

    @Override
    public void insert(Meal meal) {

    }
}
