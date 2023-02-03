package com.example.foodplanner.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Meals;
import com.example.foodplanner.view.MealAdapter;
import com.example.foodplanner.view.OnClickMealHome;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnClickMealHome {
    private RecyclerView recyclerView;
    private List<Meals> mealsArray;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerMeal);
        mealsArray = new ArrayList<>();
        mealsArray.add(new Meals("Tart","dessert","https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg","British", null));
        mealsArray.add(new Meals("Apam balik","Beef",
                "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg","Malaysian", "https://www.nyonyacooking.com/recipes/apam-balik~SJ5WuvsDf9WQ"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MealAdapter(mealsArray,this.getContext(),this));
        return view;
    }

    @Override
    public void onClick(Meals meal) {

    }
}