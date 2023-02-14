package com.example.foodplanner.plan.planView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.database.AppDatabase;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.database.MealDAO;
import com.example.foodplanner.details.detailsView.DetailsActivity;
import com.example.foodplanner.favorite.favoriteView.FavoriteAdapter;
import com.example.foodplanner.home.homePressenter.MealPressenter;
import com.example.foodplanner.home.homePressenter.MealPressenterInterface;
import com.example.foodplanner.home.homeView.HomeMealAdapter;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.plan.planPressenter.PlanPressenter;
import com.example.foodplanner.plan.planPressenter.PlanPressenterInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PlanFragment extends Fragment implements OnClickPlan, PlanInterface{
    TextView sun ;
    TextView mon ;
    TextView tue ;
    TextView wed ;
    TextView thu ;
    TextView fri ;
    TextView sat ;
    RecyclerView recyclerView;
    static PlanPressenterInterface planPressenterInterface;
    PlanAdapter planAdapter;
    public PlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_plan, container, false);
       recyclerView=view.findViewById(R.id.recycler);
        planAdapter = new PlanAdapter(getContext(), new ArrayList<>(), this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(planAdapter);

       //sun...............................
        sun = view.findViewById(R.id.sunday);
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                sun.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                sun.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Sunday"), getContext()), getContext());
                planPressenterInterface.getMeal("sunday");
            }
        });

        //mon...............................
        mon = view.findViewById(R.id.monday);
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                mon.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                mon.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Monday"), getContext()), getContext());
                planPressenterInterface.getMeal("monday");

            }
        });

        //tue...............................
        tue = view.findViewById(R.id.tuesday);
        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                tue.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                tue.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Tuesday"), getContext()), getContext());
                planPressenterInterface.getMeal("tuesday");
            }
        });

        //wed...............................
        wed = view.findViewById(R.id.wednesday);
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                wed.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                wed.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Wednesday"), getContext()), getContext());
                planPressenterInterface.getMeal("wednesday");
            }
        });
        //thu...............................
        thu = view.findViewById(R.id.thursday);
        thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                thu.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                thu.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Thursday"), getContext()), getContext());
                planPressenterInterface.getMeal("thursday");

            }
        });

        //fri...............................
        fri = view.findViewById(R.id.friday);
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllBackground();
                fri.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                fri.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Friday"), getContext()), getContext());
                planPressenterInterface.getMeal("friday");
            }
        });

        //sat...............................
        sat = view.findViewById(R.id.saturday);
        sat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setAllBackground();
                sat.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                sat.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
                planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"Saturday"), getContext()), getContext());
                planPressenterInterface.getMeal("saturday");
            }
        });
        return view;
    }

    private void setAllBackground(){
        sun.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        sun.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        mon.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        mon.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        tue.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        tue.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        wed.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        wed.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        thu.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        thu.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        fri.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        fri.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        sat.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_dark));
        sat.setTextColor(ContextCompat.getColor(getContext(), R.color.white));

    }

    @Override
    public void onClickDetails(Meal meal) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("MealFragment", (Serializable) meal);
        startActivity(intent);

    }

    @Override
    public void onClickRemove(Meal meal) {
        deleteMeal(meal);
    }


    @Override
    public void showPlan(Observable<List<Meal>> meal) {

            meal.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            item -> planAdapter.setMealsArrayList(item),
                            error -> Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show()
                    );
            planAdapter.notifyDataSetChanged();
    }

    @Override
    public void deleteMeal(Meal meal) {
        planPressenterInterface= new PlanPressenter(PlanFragment.this, Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext(),"0"), getContext()), getContext());
        planPressenterInterface.deleteMeal(meal);
    }
}