package com.example.foodplanner.home.homeView;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.MainActivity;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.details.detailsView.DetailsActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.home.homePressenter.MealPressenter;
import com.example.foodplanner.home.homePressenter.MealPressenterInterface;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.CheckInternet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnClickMealHome,HomeInterface{
    ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    MealPressenterInterface mealPressenterInterface;
    View view;

    HomeMealAdapter homeMealAdapter;
    Boolean favFlag = false;
    ImageView noWifif;
    TextView noWifiText;


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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        noWifif=view.findViewById(R.id.wifiImg);
        noWifiText=view.findViewById(R.id.noWifi);
        noWifiText.setVisibility(View.INVISIBLE);
        noWifif.setVisibility(View.INVISIBLE);
        if (CheckInternet.getConnectivity(getContext())) {

            viewPager2 = view.findViewById(R.id.slider);
            homeMealAdapter = new HomeMealAdapter(new ArrayList<>(), this.getContext(), this, viewPager2);
            viewPager2.setAdapter(homeMealAdapter);
            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setOffscreenPageLimit(3);
            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });
            viewPager2.setPageTransformer(compositePageTransformer);
            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    sliderHandler.removeCallbacks(sliderRunnable);
                    sliderHandler.postDelayed(sliderRunnable, 2000);

                }
            });


            mealPressenterInterface = new MealPressenter(this,
                    Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(getContext()), getContext()),
                    ApiClient.getInstance(), getContext());
            mealPressenterInterface.getMeal();


        }
        else{
            Toast.makeText(getContext(), R.string.checkConnection, Toast.LENGTH_SHORT).show();
            noWifiText.setVisibility(View.VISIBLE);
            noWifif.setVisibility(View.VISIBLE);
        }
        return view;
    }

    @Override
    public void showMeal(List<Meal> meal) {
        homeMealAdapter.setMealsArrayList(meal);
        homeMealAdapter.notifyDataSetChanged();
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
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("MealFragment", (Serializable) meal);
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
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}