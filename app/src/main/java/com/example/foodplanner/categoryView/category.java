package com.example.foodplanner.categoryView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Category;

import java.util.ArrayList;

public class category extends Fragment {
 RecyclerView recyclerView;
 CategoryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView= view . findViewById(R.id.catRV);
        ArrayList<Category>categories = new ArrayList<>();
        categories.add(new Category("Beef","https://www.themealdb.com/images/category/beef.png"));
        categories.add(new Category("Chicken","https://www.themealdb.com/images/category/chicken.png"));
        categories.add(new Category("Dessert","https://www.themealdb.com/images/category/dessert.png"));
        categories.add(new Category("Lamb","https://www.themealdb.com/images/category/lamb.png"));
        categories.add(new Category("Miscellaneous","https://www.themealdb.com/images/category/miscellaneous.png"));
        adapter=new CategoryAdapter(categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}