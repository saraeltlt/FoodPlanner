package com.example.foodplanner.meal.mealView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.home.homeView.OnClickMealHome;
import com.example.foodplanner.meal.mealPresenter.SearchMealPresenter;
import com.example.foodplanner.meal.mealPresenter.SearchMealPresenterInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MealFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MealFragment extends Fragment implements MealInterface,OnClickMealHome {
    RecyclerView recyclerView;
    SearchMealPresenterInterface searchMealPresenterInterface;
    MealAdapter adapter;

    public MealFragment() {
        // Required empty public constructor
    }

    public static MealFragment newInstance(String param1, String param2) {
        MealFragment fragment = new MealFragment();
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
        adapter=new MealAdapter(new ArrayList<>(),getContext(),this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchMealPresenterInterface=new SearchMealPresenter(this, ApiClient.getInstance(),getContext());
        searchMealPresenterInterface.getMeal();
      //  recyclerView.setAdapter(new FavoriteAdapter(mealsArrayList, this.getContext(), this));
        return view;
    }


    @Override
    public void showMeal(List<Meal> meal) {
        adapter.setMealsArrayList(meal);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClickDetails(Meal meal) {

    }

    @Override
    public void onClickAddFav(Meal meal) {

    }

    @Override
    public void onClickRemoveFav(Meal meal) {

    }
}