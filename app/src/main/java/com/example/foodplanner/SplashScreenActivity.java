package com.example.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView imge ;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imge=findViewById(R.id.logoIcon);
        text=findViewById(R.id.appName);
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
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