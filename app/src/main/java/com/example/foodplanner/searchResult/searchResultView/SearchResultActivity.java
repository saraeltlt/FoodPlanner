package com.example.foodplanner.searchResult.searchResultView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.foodplanner.R;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.details.detailsView.DetailsActivity;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.searchResult.searchResultPressenter.SearchResultPressenter;
import com.example.foodplanner.searchResult.searchResultPressenter.SearchResultPressenterInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity implements OnClickSearch, SearchResultInterface{
    RecyclerView recyclerView ;
    EditText search;
    SearchResultAdapter adapter;
    String searchStr;
    SearchResultPressenterInterface pressenterInterface;



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
        pressenterInterface= new SearchResultPressenter(this,
                Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(this, "0"), this),
                ApiClient.getInstance(), this);
        Intent myIntent = getIntent();
        if(myIntent.getSerializableExtra("CategoryFragment")!=null) {
            searchStr = (String) myIntent.getSerializableExtra("CategoryFragment");
            pressenterInterface.getMeal(searchStr);
        }
        else if(myIntent.getSerializableExtra("AreaFragment")!=null) {
            searchStr = (String) myIntent.getSerializableExtra("AreaFragment");
            pressenterInterface.getMealByArea(searchStr);
        }



    }

    @Override
    public void onClickDetails(Meal meal) {


        pressenterInterface.getDeatiledMeal(meal.getStrMeal());


    }

    @Override
    public void showMeal(List<Meal> meal) {
        adapter.setMealsArrayList(meal);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void passMealDetails(List<Meal> meal) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("MealFragment", (Serializable) meal.get(0));
        startActivity(intent);
    }
}