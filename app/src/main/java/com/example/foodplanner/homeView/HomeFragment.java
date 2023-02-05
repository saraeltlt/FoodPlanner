package com.example.foodplanner.homeView;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodplanner.DetailsActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Meals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnClickMealHome {
    private RecyclerView recyclerView;
    private List<Meals> mealsArray;
    View view;


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
        view= inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerMeal);
        mealsArray = new ArrayList<>();
        mealsArray.add(new Meals("Tart","dessert","https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg","British", "https://www.youtube.com/watch?v=rp8Slv4INLk"));
        mealsArray.add(new Meals("Apam balik","Beef",
                "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg","Malaysian", null));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager. HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MealAdapter(mealsArray,this.getContext(),this));
        return view;
    }

    @Override
    public void onClick(Meals meal) {
        Toast.makeText(this.getContext(), meal.getStrMeal(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("meal", (Serializable) meal);
        startActivity(intent);

    }
}