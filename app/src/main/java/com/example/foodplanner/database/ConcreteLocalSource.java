package com.example.foodplanner.database;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.foodplanner.model.Meal;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ConcreteLocalSource implements LocalSource {
    private Context context;
    private MealDAO dao;
    private List<Meal> favoriteMeals;
    private static ConcreteLocalSource instance = null;
    public static ConcreteLocalSource getInstance(Context context){
        if(instance ==null){
            instance = new ConcreteLocalSource(context);
        }
        return instance;
    }
    @SuppressLint("CheckResult")
    private ConcreteLocalSource(Context context){
        this.context=context;
        AppDatabase db = AppDatabase.getInstance(context.getApplicationContext());
        dao = db.mealDAO();
        dao.getMeals().subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( item ->favoriteMeals=item);
    }
    @Override
    public List<Meal> getFavoriteMeals() {
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
}
