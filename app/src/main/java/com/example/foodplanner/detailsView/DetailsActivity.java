package com.example.foodplanner.detailsView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Meal;
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
    Boolean planFlag = false;

    ImageView flagImage;
    RecyclerView ingrediantRecycler;
    RecyclerView recipeRecycler;
    YouTubePlayerView youTubePlayerView;
    AutoCompleteTextView autoCompleteTextView;

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
        autoCompleteTextView=findViewById(R.id.addPlan);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.days));


        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!planFlag){
                    autoCompleteTextView.showDropDown();
                    planFlag=true;
                }
                else{
                    autoCompleteTextView.dismissDropDown();
                    planFlag=false;
                }


            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DetailsActivity.this, "Meal added to "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                autoCompleteTextView.setHint("Add to plane");
            }
        });







        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!favFlag) {
                    addFav.setImageResource(R.drawable.favorite_red);
                    favFlag = true;
                } else {
                    addFav.setImageResource(R.drawable.favorite_white);
                    favFlag = false;
                }
            }
        });

        Intent myIntent = getIntent();
        Meal myMeal = (Meal) myIntent.getSerializableExtra("meal");
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
                   // display errir image//
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