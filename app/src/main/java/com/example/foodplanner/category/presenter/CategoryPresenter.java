package com.example.foodplanner.category.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.category.categoryView.CategoryInterface;
import com.example.foodplanner.model.Area;
import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Ingredients;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;

public class CategoryPresenter implements CategoryPresenterInterface, NetworkDelegate {
    private CategoryInterface categoryInterface;
    private ApiClient client ;
    private Context context;

    public CategoryPresenter(CategoryInterface categoryInterface, ApiClient client, Context context) {
        this.categoryInterface = categoryInterface;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getCategory() {
        client.ObserveCategory(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Meal> meal) {

    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {

    }

    @Override
    public void onSuccessResultArea(ArrayList<Area> areas) {

    }

    @Override
    public void onSuccessResultCategory(ArrayList<Category> categories) {
       categoryInterface.showCategory(categories);
    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
        Log.i("TAG", "onFailureResult: "+errormMsg);
    }
}
