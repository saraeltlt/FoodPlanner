package com.example.foodplanner.area.areaPresenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.area.areaView.AreaInterface;
import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;

public class AreaPresenter implements AreaPresenterInterface, NetworkDelegate {
    private AreaInterface areaInterface;
    private ApiClient client ;
    private Context context;

    public AreaPresenter(AreaInterface areaInterface, ApiClient client, Context context) {
        this.areaInterface = areaInterface;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getArea() {
        client.ObserveArea(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Meal> meal) {

    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {

    }

    @Override
    public void onSuccessResultArea(ArrayList<Area> areas) {
        areaInterface.showArea(areas);
    }

    @Override
    public void onSuccessResultCategory(ArrayList<Category> categories) {

    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
        Log.i("TAG", "onFailureResult: "+errormMsg);
    }
}
