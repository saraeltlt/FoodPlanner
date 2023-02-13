package com.example.foodplanner.welcomeView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodplanner.UI.HomeActivity;
import com.example.foodplanner.UI.MainActivity;
import com.example.foodplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView imge ;
    TextView text;
    Intent intent;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        Log.i("TAG", "onStart: "+currentUser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imge=findViewById(R.id.logoIcon);
        text=findViewById(R.id.appName);
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {//if firebase
                if(currentUser==null) {
                    intent = new Intent(SplashScreenActivity.this, MainActivity.class);//WelcomeActivity.class
                }else {
                    intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                }
                Pair[] pairs =  new Pair[2];
                pairs[0]=new Pair<View,String>(imge,"imageTransition");
                pairs[1]=new Pair<View,String>(text,"textTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this, pairs);

                startActivity(intent,options.toBundle());
                finish();

            }
        },4500);
    }
}