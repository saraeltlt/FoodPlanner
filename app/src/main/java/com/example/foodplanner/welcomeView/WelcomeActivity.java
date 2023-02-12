package com.example.foodplanner.welcomeView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.foodplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
   /* private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  if(currentUser.getEmail().isEmpty()) {
            setContentView(R.layout.activity_welocme);
       // }else
          //  setContentView(R.layout.activity_home);

    }
}