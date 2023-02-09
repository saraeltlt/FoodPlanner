package com.example.foodplanner.homeView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.favoriteView.FavoriteAdapter;
import com.example.foodplanner.model.meals;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link meal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class meal extends Fragment implements OnClickMealHome {
    RecyclerView recyclerView;
    ArrayList<meals> mealsArrayList;

    public meal() {
        // Required empty public constructor
    }

    public static meal newInstance(String param1, String param2) {
        meal fragment = new meal();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal, container, false);
        recyclerView = view.findViewById(R.id.mealRV);
        mealsArrayList = new ArrayList<>();
        mealsArrayList.add(new meals("Tart", "dessert", "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg", "British",null,null));
        mealsArrayList.add(new meals("Apam balik", "Beef", "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg", "Malaysian", "https://www.nyonyacooking.com/recipes/apam-balik~SJ5WuvsDf9WQ",null));
        mealsArrayList.add(new meals("Tart", "dessert", "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg", "British", null,null));
        mealsArrayList.add(new meals("Apam balik", "Beef", "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg", "Malaysian", "https://www.nyonyacooking.com/recipes/apam-balik~SJ5WuvsDf9WQ",null));
        mealsArrayList.add(new meals("Tart", "dessert", "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg", "British", null,null));
        mealsArrayList.add(new meals("Apam balik", "Beef", "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg", "Malaysian", "https://www.nyonyacooking.com/recipes/apam-balik~SJ5WuvsDf9WQ",null));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new FavoriteAdapter(mealsArrayList, this.getContext(), this));
        return view;
    }

    @Override
    public void onClick(meals meal) {

    }
}