package com.example.foodplanner.ingrediant.ingredientView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.foodplanner.R;
import com.example.foodplanner.ingrediant.ingredientPresenter.IngredientPresenter;
import com.example.foodplanner.ingrediant.ingredientPresenter.IngredientPresenterInterface;
import com.example.foodplanner.ingrediant.ingrediantModel.Ingredients;
import com.example.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class IngredientsFragment extends Fragment implements IngredientInterface {
    RecyclerView recyclerView ;
    IngrediantAdapter adapter;
    EditText search;

    IngredientPresenterInterface ingredientPresenterInterface;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ingredients, container, false);
        search = view.findViewById(R.id.ingredsearchView);
        recyclerView = view.findViewById(R.id.ingRV);
        adapter = new IngrediantAdapter(new ArrayList<>());
        ingredientPresenterInterface=new IngredientPresenter(this,ApiClient.getInstance(),getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        ingredientPresenterInterface.getIngredient();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.updateList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }
    @Override
    public void showIngredient(List<Ingredients> ingredients) {
        adapter.setList(ingredients);
        adapter.notifyDataSetChanged();
    }

/*public static void searchRes(String n){
    ingredientPresenterInterface.getSearchData(name);
}*/

}