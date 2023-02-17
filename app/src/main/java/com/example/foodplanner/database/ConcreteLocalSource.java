package com.example.foodplanner.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.foodplanner.mealModel.Meal;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ConcreteLocalSource implements LocalSource {
    private Context context;
    private MealDAO dao;
    private Observable<List<Meal>> favoriteMeals;
    private Observable<List<Meal>> planMeals;
    private static ConcreteLocalSource instance = null;
    public static ConcreteLocalSource getInstance(Context context , String day){
        if(instance ==null){
            instance = new ConcreteLocalSource(context,day);
        }
        return instance;
    }
    @SuppressLint("CheckResult")
    private ConcreteLocalSource(Context context,String day){
        this.context=context;
        AppDatabase appDataBase = AppDatabase.getInstance(context.getApplicationContext());
        dao = appDataBase.mealDAO();
        if(day.equals("0"))
        favoriteMeals = dao.getMeals(day);
    }
     @Override
    public Observable<List<Meal>> getFavoriteMeals() {
        return favoriteMeals;
    }

    @Override
    public void delete(Meal meal) {
        dao.deleteMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });

    }

    @Override
    public void deleteAll() {
        dao.deleteAll().subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });

    }

    @Override
    public void insert(Meal meal) {
        dao.insertMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });

    }

    @Override
    public Observable<List<Meal>> getMealsPlan(String day) {
        AppDatabase appDataBase = AppDatabase.getInstance(context.getApplicationContext());
        MealDAO dao = appDataBase.mealDAO();
        planMeals=dao.getPlanMeals(day);
        return planMeals;
    }

}
