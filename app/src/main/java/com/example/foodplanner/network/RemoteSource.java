package com.example.foodplanner.network;

public interface RemoteSource {
    void ObserveMeal(NetworkDelegate networkDelegate);
    void ObserveIngrediant(NetworkDelegate networkDelegate);
    void ObserveArea(NetworkDelegate networkDelegate);
    void ObserveCategory(NetworkDelegate networkDelegate);
}
