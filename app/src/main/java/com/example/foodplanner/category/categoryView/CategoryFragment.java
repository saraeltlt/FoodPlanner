package com.example.foodplanner.category.categoryView;

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
import com.example.foodplanner.searchResult.searchResultView.SearchResultActivity;
import com.example.foodplanner.category.categoryPresenter.CategoryPresenter;
import com.example.foodplanner.category.categoryPresenter.CategoryPresenterInterface;
import com.example.foodplanner.category.categoryModel.Category;
import com.example.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements CategoryInterface,Onclick{
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private CategoryPresenterInterface categoryPresenterInterface;
    private EditText search;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView= view . findViewById(R.id.catRV);
        search=view.findViewById(R.id.catSearchView);
        adapter=new CategoryAdapter(new ArrayList<>(),this);
        categoryPresenterInterface=new CategoryPresenter(this,ApiClient.getInstance(),getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
        categoryPresenterInterface.getCategory();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.updateList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

    @Override
    public void showCategory(List<Category> categories) {
        adapter.setList(categories);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnclickMeal(Category category) {
        Intent intent = new Intent(getActivity(), SearchResultActivity.class);
        intent.putExtra("CategoryFragment",category.getStrCategory());
        startActivity(intent);

    }
}