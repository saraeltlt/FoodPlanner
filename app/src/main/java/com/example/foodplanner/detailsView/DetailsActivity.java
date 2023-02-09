package com.example.foodplanner.detailsView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.model.meals;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DetailsActivity extends AppCompatActivity {

    TextView mealName;
    TextView mealArea;
    ImageView mealImage;
    ImageButton addFav;
    Boolean favFlag = false;
    ImageView flagImage;
    RecyclerView ingrediantRecycler;
    RecyclerView recipeRecycler;
    YouTubePlayerView youTubePlayerView;
    private List<meals> mealsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        recipeRecycler = findViewById(R.id.recyclerRecipe);
        youTubePlayerView = findViewById(R.id.youtubePlayer);
        mealName = findViewById(R.id.meal);
        mealArea = findViewById(R.id.area);
        ingrediantRecycler = findViewById(R.id.recycler);
        flagImage = findViewById(R.id.areaFlag);
        mealImage = findViewById(R.id.image);
        addFav = findViewById(R.id.addFav);


        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!favFlag) {
                    addFav.setImageResource(R.drawable.favorite_yellow);
                    favFlag = true;
                } else {
                    addFav.setImageResource(R.drawable.favorite_white);
                    favFlag = false;
                }
            }
        });

        Intent myIntent = getIntent();
        meals myMeal = (meals) myIntent.getSerializableExtra("meal");
        mealName.setText(myMeal.getStrMeal());
        mealArea.setText(myMeal.getStrArea());
        Context context = flagImage.getContext();
        int id = context.getResources().getIdentifier(myMeal.getStrArea().toLowerCase(), "drawable", context.getPackageName());
        flagImage.setImageResource(id);
        Glide.with(this).load(myMeal.getStrMealThumb()).into(mealImage);
        getLifecycle().addObserver(youTubePlayerView);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ingrediantRecycler.setLayoutManager(manager);
        ingrediantRecycler.setAdapter(new IngredientsCardAdapter(myMeal, this));

        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                String videoId = myMeal.getStrYoutube();
                if (videoId != null) {
                    videoId = videoId.substring(videoId.indexOf("=") + 1);
                    StringTokenizer st = new StringTokenizer(videoId, "&");
                    videoId = st.nextToken();
                    youTubePlayer.loadVideo(videoId, 0);
                }
                else{
                   // display image//
                }
            }
        });

        StringTokenizer st = new StringTokenizer(myMeal.getStrInstructions(), ".");
        List<String> recipe = new ArrayList<>();
        while (st.hasMoreTokens()) {
            recipe.add(st.nextToken());
        }
        RecyclerView.LayoutManager managerRecipe = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recipeRecycler.setLayoutManager(managerRecipe);
        recipeRecycler.setAdapter(new RecipeCardAdapter(recipe, this));


    }
}