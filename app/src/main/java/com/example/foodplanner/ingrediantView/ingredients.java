package com.example.foodplanner.ingrediantView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Ingredients;

import java.util.ArrayList;


public class ingredients extends Fragment {
    RecyclerView recyclerView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ingredients, container, false);
        recyclerView = view.findViewById(R.id.ingRV);
        ArrayList<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Beef"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Beef"));
        ingredients.add(new Ingredients("Salmon"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Salmon"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Salmon"));
        ingredients.add(new Ingredients("Salmon"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        ingredients.add(new Ingredients("Chicken"));
        ingredients.add(new Ingredients("Asparagus"));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new IngrediantAdapter(ingredients));
        return view;
    }
}