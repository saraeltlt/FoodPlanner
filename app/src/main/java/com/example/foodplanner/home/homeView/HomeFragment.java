package com.example.foodplanner.home.homeView;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.detailsView.DetailsActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.home.homePressenter.MealPressenter;
import com.example.foodplanner.home.homePressenter.MealPressenterInterface;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class HomeFragment extends Fragment implements OnClickMealHome,HomeInterface{
    private RecyclerView recyclerView;
    MealPressenterInterface mealPressenterInterface;
    View view;
    MealAdapter mealAdapter;
    Boolean favFlag = false;


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
        mealAdapter=new MealAdapter( new ArrayList<>(),this.getContext(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager. HORIZONTAL, false));
        recyclerView.setAdapter(mealAdapter);
        mealPressenterInterface= new MealPressenter(this,
                Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext()),getContext()),
                ApiClient.getInstance(),getContext());
        mealPressenterInterface.getMeal();

        return view;
    }

    @Override
    public void showMeal(List<Meal> meal) {
        mealAdapter.setMealsArrayList(meal);
        mealAdapter.notifyDataSetChanged();
    }

    @Override
    public void addMeal(Meal meal) {
        mealPressenterInterface.addToFav(meal);

    }

    @Override
    public void deleteMeal(Meal meal) {
        mealPressenterInterface.deleteMeal(meal);
    }

    @Override
    public void onClickDetails(Meal meal) {
        Toast.makeText(this.getContext(), meal.getStrMeal(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("meal", (Serializable) meal);
        startActivity(intent);
    }

    @Override
    public void onClickAddFav(Meal meal) {
            mealPressenterInterface.addToFav(meal);
    }

    @Override
    public void onClickRemoveFav(Meal meal) {
        mealPressenterInterface.deleteMeal(meal);
    }
}