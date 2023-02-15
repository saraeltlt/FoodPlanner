package com.example.foodplanner.ingrediant.ingredientPresenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.ingrediant.ingredientView.IngredientInterface;
import com.example.foodplanner.area.areaModel.Area;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.NetworkDelegate;

import java.util.ArrayList;

public class IngredientPresenter implements  IngredientPresenterInterface, NetworkDelegate {
   private IngredientInterface ingredientInterface;
   private ApiClient client;
   private Context context;

    public IngredientPresenter(IngredientInterface ingredientInterface, ApiClient client, Context context) {
        this.ingredientInterface = ingredientInterface;
        this.client = client;
        this.context = context;
    }

    @Override
    public void getIngredient() {
        client.ObserveIngrediant(this);
    }
   /* @Override
    public void getSearchData(String n){
        client.searchIngrediant(this,n);
    }
*/
    @Override
    public void onSuccessResultMeal(ArrayList<Meal> meal) {
        //Nothing
    }

    @Override
    public void onSuccessResultIngrediants(ArrayList<Ingredients> ingredients) {
        ingredientInterface.showIngredient(ingredients);
    }

    @Override
    public void onSuccessResultArea(ArrayList<Area> ingredients) {

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
