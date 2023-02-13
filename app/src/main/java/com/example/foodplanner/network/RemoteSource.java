package com.example.foodplanner.network;

public interface RemoteSource {
    void ObserveMeal(NetworkDelegate networkDelegate);
    void ObserveIngrediant(NetworkDelegate networkDelegate);
}
