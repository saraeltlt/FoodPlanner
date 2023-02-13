package com.example.foodplanner;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.foodplanner.categoryView.category;
import com.example.foodplanner.ingrediant.ingredientView.IngredientsFragment;
import com.example.foodplanner.categoryView.areaView.Area;


public class SearchFragment extends Fragment {

    Button ing, area, cat, meal;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ing=view.findViewById(R.id.ingrediantBtn);
        area=view.findViewById(R.id.areaBtn);
        cat=view.findViewById(R.id.categoryBtn );
        meal=view.findViewById(R.id.mealBtn);
        ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredientsFragment ingFrag = new IngredientsFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment,ingFrag,"ingFrag").commit();
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Area regionFrag = new Area();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment,regionFrag,"ingFrag").commit();
            }
        });
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category catFrag = new category();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment,catFrag,"ingFrag").commit();
            }
        });
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealFragment mealFrag = new MealFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment,mealFrag,"ingFrag").commit();

            }
        });
        return view;
    }
}