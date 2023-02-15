package com.example.foodplanner.SearchResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import com.example.foodplanner.R;
import com.example.foodplanner.meal.mealView.MealAdapter;
import com.example.foodplanner.mealModel.Meal;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity implements OnClick {
    RecyclerView recyclerView ;
    EditText search;
    SearchResultAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        recyclerView = findViewById(R.id.mealRV);
        search = findViewById(R.id.searchText);
        adapter=new SearchResultAdapter(new ArrayList<>(),this,this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClickDetails(Meal meal) {

    }
}