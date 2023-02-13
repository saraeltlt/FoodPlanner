package com.example.foodplanner.details.detailsView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.foodplanner.HomeActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.details.detailsPressenter.DetailsMealPressenter;
import com.example.foodplanner.details.detailsPressenter.DetailsMealPressenterInterface;
import com.example.foodplanner.home.homePressenter.MealPressenter;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.CheckInternet;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DetailsActivity extends AppCompatActivity implements DetailsInterface {
    TextView mealName;
    TextView mealArea;
    ImageView mealImage;
    ImageButton addFav;
    Boolean planFlag = false;
    ImageView noWifif;
    TextView noWifiText;
    ImageView flagImage;
    RecyclerView ingrediantRecycler;
    RecyclerView recipeRecycler;
    YouTubePlayerView youTubePlayerView;
    AutoCompleteTextView autoCompleteTextView;
    DetailsMealPressenterInterface detailsMealPressenterInterface;

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
        noWifif=findViewById(R.id.wifiImg);
        noWifiText=findViewById(R.id.noWifi);
        autoCompleteTextView=findViewById(R.id.addPlan);
        Intent myIntent = getIntent();
        Meal myMeal = (Meal) myIntent.getSerializableExtra("MealFragment");
        setView(myMeal);

        detailsMealPressenterInterface= new DetailsMealPressenter(this,
                Repository.getInstance(ApiClient.getInstance(), ConcreteLocalSource.getInstance(this),this),
                ApiClient.getInstance(),this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.days));
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeActivity.getGuestFlag()){
                    Toast.makeText(DetailsActivity.this, R.string.access, Toast.LENGTH_SHORT).show();
                }
                else {
                    autoCompleteTextView.showDropDown();
                    planFlag = true;
                }
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DetailsActivity.this, "Meal added to "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

        });


        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeActivity.getGuestFlag()){
                    Toast.makeText(DetailsActivity.this, R.string.access, Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!myMeal.getMealAddedToFav()) {
                        addFav.setImageResource(R.drawable.favorite_red);
                        myMeal.setMealAddedToFav(true);
                        addMealToFav(myMeal);
                    } else {
                        addFav.setImageResource(R.drawable.favorite_white);
                        myMeal.setMealAddedToFav(false);
                        deleteMealFromFav(myMeal);
                    }
                }
            }
        });

    }


    @Override
    public void addMealToFav(Meal meal) {
        detailsMealPressenterInterface.addToFav(meal);

    }

    @Override
    public void deleteMealFromFav(Meal meal) {
        detailsMealPressenterInterface.deleteMealFromFav(meal);

    }

    @Override
    public void addMealToPlan(Meal meal) {

    }
    public void setView(Meal myMeal){
        mealName.setText(myMeal.getStrMeal());
        mealArea.setText(myMeal.getStrArea());
        if(myMeal.getMealAddedToFav()){
            addFav.setImageResource(R.drawable.favorite_red);
        }
        Context context = flagImage.getContext();
        int id = context.getResources().getIdentifier(myMeal.getStrArea().toLowerCase(), "drawable", context.getPackageName());
        flagImage.setImageResource(id);
        Glide.with(this).load(myMeal.getStrMealThumb()).into(mealImage);
        showVideo(myMeal.getStrYoutube());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ingrediantRecycler.setLayoutManager(manager);
        ingrediantRecycler.setAdapter(new IngredientsCardAdapter(myMeal, this));

        StringTokenizer st = new StringTokenizer(myMeal.getStrInstructions().replace("\n", ""), ".");
        List<String> recipe = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (word.length()>2) {
                recipe.add(word);
            }
        }
        RecyclerView.LayoutManager managerRecipe = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recipeRecycler.setLayoutManager(managerRecipe);
        recipeRecycler.setAdapter(new RecipeCardAdapter(recipe, this));
    }
    public void showVideo (String url){
        if (CheckInternet.getConnectivity(DetailsActivity.this)) {
            noWifiText.setVisibility(View.INVISIBLE);
            noWifif.setVisibility(View.INVISIBLE);
            youTubePlayerView.setVisibility(View.VISIBLE);
            getLifecycle().addObserver(youTubePlayerView);
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = url;
                    if (videoId != null) {
                        videoId = videoId.substring(videoId.indexOf("=") + 1);
                        StringTokenizer st = new StringTokenizer(videoId, "&");
                        videoId = st.nextToken();
                        youTubePlayer.loadVideo(videoId, 0);
                    } else {
                        // display errir image//
                    }
                }
            });
        }
        else{
            noWifiText.setVisibility(View.VISIBLE);
            noWifif.setVisibility(View.VISIBLE);
            youTubePlayerView.setVisibility(View.INVISIBLE);

        }

    }
}