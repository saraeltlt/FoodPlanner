package com.example.foodplanner.UI;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.foodplanner.R;
import com.example.foodplanner.category.categoryView.category;
import com.example.foodplanner.ingrediant.ingredientView.IngredientsFragment;
import com.example.foodplanner.area.areaView.AreaViewClass;
import com.example.foodplanner.meal.mealView.MealFragment;
import com.example.foodplanner.network.CheckInternet;


public class SearchFragment extends Fragment {

    Button ing, area, cat, meal;
    ImageView noWifif;
    TextView noWifiText;
    LinearLayout layout;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        noWifif=view.findViewById(R.id.wifiImg);
        noWifiText=view.findViewById(R.id.noWifi);
        layout=view.findViewById(R.id.searchLayout);
        ing = view.findViewById(R.id.ingrediantBtn);
        area = view.findViewById(R.id.areaBtn);
        cat = view.findViewById(R.id.categoryBtn);
        meal = view.findViewById(R.id.mealBtn);
        if (CheckInternet.getConnectivity(getContext())) {
            noWifiText.setVisibility(View.INVISIBLE);
            noWifif.setVisibility(View.INVISIBLE);
            layout.setVisibility(View.VISIBLE);
            ing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IngredientsFragment ingFrag = new IngredientsFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment, ingFrag, "ingFrag").commit();
                }
            });
            area.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AreaViewClass regionFrag = new AreaViewClass();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment, regionFrag, "ingFrag").commit();
                }
            });
            cat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    category catFrag = new category();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment, catFrag, "ingFrag").commit();
                }
            });
            meal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MealFragment mealFrag = new MealFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().setReorderingAllowed(true).replace(R.id.navHostFragment, mealFrag, "ingFrag").commit();
                }
            });
        }
        else{
                Toast.makeText(getContext(), R.string.checkConnection, Toast.LENGTH_SHORT).show();
                noWifiText.setVisibility(View.VISIBLE);
                noWifif.setVisibility(View.VISIBLE);
                layout.setVisibility(View.INVISIBLE);
            }

        return view;
    }
}