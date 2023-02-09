package com.example.foodplanner.network;

import com.example.foodplanner.model.meals;

import java.util.ArrayList;

public interface NetworkDelegate {
    public void onSuccessResult(ArrayList<meals> products);
    public void onFailureResult(String errormMsg);
}
