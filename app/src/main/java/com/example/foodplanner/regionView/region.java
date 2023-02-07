package com.example.foodplanner.regionView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Area;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link region#newInstance} factory method to
 * create an instance of this fragment.
 */
public class region extends Fragment {
    RecyclerView recyclerView;
    RegionAdapter adapter;
    LinearLayoutManager manager;

    public static region newInstance(String param1, String param2) {
        region fragment = new region();
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
      ArrayList<Area> countries=new ArrayList<>();
      countries.add(new Area("American"));
      countries.add(new Area("British"));
      countries.add(new Area("Canadian"));
      countries.add(new Area("Chinese"));
      countries.add(new Area("Croatian"));
      countries.add(new Area("Dutch"));
      countries.add(new Area("Egyptian"));
      countries.add(new Area("French"));
      adapter = new RegionAdapter(countries);
      manager = new LinearLayoutManager(this.getContext());
      recyclerView.setLayoutManager(manager);
      recyclerView.setAdapter(adapter);
        return view;
    }
}