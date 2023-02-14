package com.example.foodplanner.UI.welcomeView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodplanner.R;


public class WelcomeFragment2 extends Fragment {
    Button nextToWelcome3;

    public WelcomeFragment2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_welcome2, container, false);
        nextToWelcome3=view.findViewById(R.id.btn_welcome2);
        nextToWelcome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_welcomeFragment2_to_welcomeFragment3);
            }
        });
        return view;
    }
}
