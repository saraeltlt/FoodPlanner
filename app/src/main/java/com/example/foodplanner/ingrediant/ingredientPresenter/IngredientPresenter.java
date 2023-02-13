package com.example.foodplanner.ingrediant.ingredientPresenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.ingrediant.ingredientView.IngredientInterface;
import com.example.foodplanner.model.Ingredients;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;

public class IngredientPresenter implements  IngredientPresenterInterface, NetworkDelegate {
   private IngredientInterface ingredientInterface;
    ApiClient client;
    Context context;

    public IngredientPresenter(IngredientInterface ingredientInterface, ApiClient client, Context context) {
        this.ingredientInterface = ingredientInterface;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getIngredient() {
        client.ObserveIngrediant(this);
    }

    @Override
    public void onSuccessResult(ArrayList<Meal> meal) {
        //Nothing
    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {
        ingredientInterface.showIngredient(ingredients);
    }

    @Override
    public void onFailureResult(String errormMsg) {
        Toast.makeText(context,errormMsg, Toast.LENGTH_SHORT).show();
        Log.i("TAG", "onFailureResult: "+errormMsg);
    }
}
