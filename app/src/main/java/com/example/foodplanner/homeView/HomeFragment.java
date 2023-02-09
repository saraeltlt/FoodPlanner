package com.example.foodplanner.homeView;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodplanner.detailsView.DetailsActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.model.RandomMeals;
import com.example.foodplanner.model.meals;
import com.example.foodplanner.network.ApiClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomeFragment extends Fragment implements OnClickMealHome {
    private RecyclerView recyclerView;
    private List<meals> mealsArray;
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
        Observable<RandomMeals> observable= ApiClient.getInstance().getMyApi().getRandomMeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager. HORIZONTAL, false));
                    recyclerView.setAdapter(new MealAdapter( o.getMeals(),this.getContext(),this));
                },
                e-> Log.i("hitest","ERROR: "+e.getMessage())
        );



        return view;
    }

    @Override
    public void onClick(meals meal) {
        Toast.makeText(this.getContext(), meal.getStrMeal(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("meal", (Serializable) meal);
        startActivity(intent);

    }

    public List<meals> getRandomMeals(List<meals> meals){
        List<meals> randomMeals= new ArrayList<>();
         int min=0,max=24;
         for (int i=0;i<5;i++) {
           meals meal= meals.get ((int) (Math.random() * (max - min)));
            randomMeals.add(meal);
         }
         return randomMeals;

    }
}