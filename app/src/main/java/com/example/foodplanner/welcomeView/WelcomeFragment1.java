package com.example.foodplanner.welcomeView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodplanner.R;

public class WelcomeFragment1 extends Fragment {
    Button nextToWelcome2;


    public WelcomeFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_welcome1, container, false);
       nextToWelcome2=view.findViewById(R.id.btn_welcome1);
       nextToWelcome2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Navigation.findNavController(view).navigate(R.id.action_welcomeFragment1_to_welcomeFragment2);
           }
       });
       return view;
    }
}