package com.example.foodplanner.favorite.favoriteView;

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
import com.example.foodplanner.favorite.favoritePressenter.FavMealPressenter;
import com.example.foodplanner.favorite.favoritePressenter.FavMealPressenterInterface;
import com.example.foodplanner.home.homeView.OnClickMealHome;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment implements OnClickFavorite,FavMealInterface {
    private RecyclerView recyclerView;

    private  FavoriteAdapter favoriteAdapter;
    FavMealPressenterInterface favMealPressenterInterface;
    View view;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        favoriteAdapter = new FavoriteAdapter(getContext(), new ArrayList<>(), this);
        favMealPressenterInterface = new FavMealPressenter(this,
                Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext()),getContext()),
                getContext());


        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(favoriteAdapter);
        favMealPressenterInterface.getMeals();
        return view;


    }



    @Override
    public void showFavData(List<Meal> meal) {
        favoriteAdapter.setMealsArrayList(meal);
        favoriteAdapter.notifyDataSetChanged();

    }

    @Override
    public void deleteMeal(Meal meal) {
        favMealPressenterInterface.deleteMeal(meal);

    }

    @Override
    public void onClickDetails(Meal meal) {
         Toast.makeText(this.getContext(), meal.getStrMeal(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("meal", (Serializable) meal);
        startActivity(intent);
    }

    @Override
    public void onClickRemoveFav(Meal meal) {
        favMealPressenterInterface.deleteMeal(meal);

    }
}