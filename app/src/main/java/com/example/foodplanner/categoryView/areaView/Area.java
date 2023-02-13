package com.example.foodplanner.categoryView.areaView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Area#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Area extends Fragment {
    RecyclerView recyclerView;
    AreaAdapter adapter;
    LinearLayoutManager manager;

    public static Area newInstance(String param1, String param2) {
        Area fragment = new Area();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.fragment_region, container, false);
      recyclerView = view .findViewById(R.id.regionRV);
      ArrayList<com.example.foodplanner.model.Area> countries=new ArrayList<>();
      countries.add(new com.example.foodplanner.model.Area("American"));
      countries.add(new com.example.foodplanner.model.Area("British"));
      countries.add(new com.example.foodplanner.model.Area("Canadian"));
      countries.add(new com.example.foodplanner.model.Area("Chinese"));
      countries.add(new com.example.foodplanner.model.Area("Croatian"));
      countries.add(new com.example.foodplanner.model.Area("Dutch"));
      countries.add(new com.example.foodplanner.model.Area("Egyptian"));
      countries.add(new com.example.foodplanner.model.Area("French"));
      adapter = new AreaAdapter(countries);
      manager = new LinearLayoutManager(this.getContext());
      recyclerView.setLayoutManager(manager);
      recyclerView.setAdapter(adapter);
        return view;
    }
}