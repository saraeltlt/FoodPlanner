package com.example.foodplanner.area.areaView;

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
import com.example.foodplanner.area.presenter.AreaPresenter;
import com.example.foodplanner.area.presenter.AreaPresenterInterface;
import com.example.foodplanner.model.Area;
import com.example.foodplanner.network.ApiClient;


import java.util.ArrayList;
import java.util.List;

public class AreaViewClass extends Fragment implements AreaInterface {
   private RecyclerView recyclerView;
    private AreaAdapter adapter;
    private LinearLayoutManager manager;
    private AreaPresenterInterface areaPresenterInterface;
    private EditText search;
    public static AreaViewClass newInstance(String param1, String param2) {
        AreaViewClass fragment = new AreaViewClass();
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
      search=view.findViewById(R.id.areaSearchView);
      adapter = new AreaAdapter(new ArrayList<>());
      areaPresenterInterface = new AreaPresenter(this, ApiClient.getInstance(),getContext());
      manager = new LinearLayoutManager(this.getContext());
      recyclerView.setLayoutManager(manager);
      recyclerView.setAdapter(adapter);
      areaPresenterInterface.getArea();
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
    public void showArea(List<Area> areas) {
        adapter.setList(areas);
        adapter.notifyDataSetChanged();
    }


}