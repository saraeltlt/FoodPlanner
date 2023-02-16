package com.example.foodplanner.meal.mealView;

import android.content.Intent;
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
import com.example.foodplanner.details.detailsView.DetailsActivity;
import com.example.foodplanner.home.homeView.OnClickMealHome;
import com.example.foodplanner.meal.mealPresenter.SearchMealPresenter;
import com.example.foodplanner.meal.mealPresenter.SearchMealPresenterInterface;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.network.ApiClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class MealFragment extends Fragment implements MealInterface,OnClickMealHome {
    RecyclerView recyclerView;
    SearchMealPresenterInterface searchMealPresenterInterface;
    MealAdapter adapter;
    EditText search;


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
            search= view.findViewById(R.id.searchText);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s!=null){
                    searchMealPresenterInterface.getMealSearch(s);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        return view;
    }


    @Override
    public void showMeal(List<Meal> meal) {
        adapter.setMealsArrayList(meal);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void searchMeal(List<Meal> meal) {
        adapter.setMealsArrayList(meal);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClickDetails(Meal meal) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("MealFragment", (Serializable) meal);
        startActivity(intent);

    }

    @Override
    public void onClickAddFav(Meal meal) {

    }

    @Override
    public void onClickRemoveFav(Meal meal) {

    }
}