package com.example.foodplanner.model;

import android.content.Context;

import com.example.foodplanner.database.LocalSource;
import com.example.foodplanner.network.NetworkDelegate;
import com.example.foodplanner.network.RemoteSource;

import java.util.List;

public class Repository implements LocalSource, RemoteSource {
    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;

    private static Repository repo = null;

    private Repository(RemoteSource remoteSource, LocalSource localSource, Context context) {
        this.context = context;
        this.remoteSource=remoteSource;
        this.localSource=localSource;

    }
    public static Repository getInstance(RemoteSource remoteSource, LocalSource localSource,Context context){
        if(repo ==null){
            repo = new Repository(remoteSource,localSource,context);
        }
        return repo;
    }
    @Override
    public List<Meal> getFavoriteMeals(){
        return localSource.getFavoriteMeals();

    }


    @Override
    public void delete(Meal meal){
      localSource.delete(meal);
    }
    @Override
    public void insert(Meal meal){
     localSource.insert(meal);
    }


    @Override
    public void ObserveMeal(NetworkDelegate networkDelegate) {
        remoteSource.ObserveMeal(networkDelegate);

    }
}
