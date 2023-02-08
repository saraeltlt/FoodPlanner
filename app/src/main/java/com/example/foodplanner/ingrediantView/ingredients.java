package com.example.foodplanner.ingrediantView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.favoriteView.FavoriteAdapter;
import com.example.foodplanner.model.Ingrd;

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
        ArrayList<Ingrd>ingrds = new ArrayList<>();
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Beef"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Beef"));
        ingrds.add(new Ingrd("Salmon"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Salmon"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Salmon"));
        ingrds.add(new Ingrd("Salmon"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        ingrds.add(new Ingrd("Chicken"));
        ingrds.add(new Ingrd("Asparagus"));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new IngrediantAdapter(ingrds));
        return view;
    }
}