package com.example.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.model.Meals;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailsActivity extends AppCompatActivity {

TextView mealName;
TextView mealArea;
ImageView mealImage;
ImageButton addFav;
Boolean favFlag = false;
ImageView flagImage;
YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        youTubePlayerView=findViewById(R.id.youtubePlayer);
        mealName = findViewById(R.id.meal);
        mealArea = findViewById(R.id.area);
        flagImage= findViewById(R.id.areaFlag);
        mealImage = findViewById(R.id.image);
        addFav= findViewById(R.id.addFav);
        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!favFlag) {
                    addFav.setImageResource(R.drawable.favorite_yellow);
                    favFlag=true;
                }
                else{
                    addFav.setImageResource(R.drawable.favorite_white);
                    favFlag=false;
                }
            }
        });

        Intent myIntent = getIntent();
        Meals myMeal = (Meals) myIntent.getSerializableExtra("meal");
        mealName.setText(myMeal.getStrMeal());
        mealArea.setText(myMeal.getStrArea());
        Glide.with(this).load(myMeal.getStrMealThumb()).into(mealImage);
        Glide.with(this).load("http://goo.gl/gEgYUd").into(flagImage);
        getLifecycle().addObserver(youTubePlayerView);
      /* youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
           @Override
           public void onReady(@NonNull YouTubePlayer youTubePlayer) {
               super.onReady(youTubePlayer);
              String videoId="gXWXKjR-qII&ab_channel=PapayaCoders";
              youTubePlayer.loadVideo(videoId,0);
           }
       });*/



    }
}