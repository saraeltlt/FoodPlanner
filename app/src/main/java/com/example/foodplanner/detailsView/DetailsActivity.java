package com.example.foodplanner.detailsView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.homeView.MealAdapter;
import com.example.foodplanner.model.Meals;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

TextView mealName;
TextView mealArea;
ImageView mealImage;
ImageButton addFav;
Boolean favFlag = false;
ImageView flagImage;
RecyclerView  recyclerView;
YouTubePlayerView youTubePlayerView;
    private List<Meals> mealsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        youTubePlayerView=findViewById(R.id.youtubePlayer);
        mealName = findViewById(R.id.meal);
        mealArea = findViewById(R.id.area);
        recyclerView =findViewById(R.id.recycler);
        flagImage= findViewById(R.id.areaFlag);
        mealImage = findViewById(R.id.image);
        addFav= findViewById(R.id.addFav);
        mealsArray = new ArrayList<>();
        mealsArray.add(new Meals("Tart","dessert","https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg","British", "https://www.youtube.com/watch?v=rp8Slv4INLk", "Preheat the oven to 200C/180C Fan/Gas 6. Put the biscuits in a large re-sealable freezer bag and bash with a rolling pin into fine crumbs. Melt the butter in a small pan, then add the biscuit crumbs and stir until coated with butter. Tip into the tart tin and, using the back of a spoon, press over the base and sides of the tin to give an even layer. Chill in the fridge while you make the filling. Cream together the butter and sugar until light and fluffy. You can do this in a food processor if you have one. Process for 2-3 minutes. Mix in the eggs, then add the ground almonds and almond extract and blend until well combined. Peel the apples, and cut thin slices of apple. Do this at the last minute to prevent the apple going brown. Arrange the slices over the biscuit base. Spread the frangipane filling evenly on top. Level the surface and sprinkle with the flaked almonds. Bake for 20-25 minutes until golden-brown and set. Remove from the oven and leave to cool for 15 minutes. Remove the sides of the tin. An easy way to do this is to stand the tin on a can of beans and push down gently on the edges of the tin. Transfer the tart, with the tin base attached, to a serving plate. Serve warm with cream, crème fraiche or ice cream."
        ));
        mealsArray.add(new Meals("Apam balik","Beef",
                "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg","Malaysian", null,"In a blender, add the ingredients for the spice paste and blend until smooth. Over medium heat, pour the spice paste in a skillet or pan and fry for 10 minutes until fragrant. Add water or oil 1 tablespoon at a time if the paste becomes too dry. Don't burn the paste. Lower the fire slightly if needed. Add the cloves, cardamom, tamarind pulp, coconut milk, water, sugar and salt. Turn the heat up and bring the mixture to boil. Turn the heat to medium low and simmer for 10 minutes. Stir occasionally. It will reduce slightly. This is the marinade/sauce, so taste and adjust seasoning if necessary. Don't worry if it's slightly bitter. It will go away when roasting. When the marinade/sauce has cooled, pour everything over the chicken and marinate overnight to two days. Preheat the oven to 425 F. Remove the chicken from the marinade. Spoon the marinade onto a greased (or aluminum lined) baking sheet. Lay the chicken on top of the sauce (make sure the chicken covers the sauce and the sauce isn't exposed or it'll burn) and spread the remaining marinade on the chicken. Roast for 35-45 minutes or until internal temp of the thickest part of chicken is at least 175 F. Let chicken rest for 5 minutes. Brush the chicken with some of the oil. Serve chicken with the sauce over steamed rice (or coconut rice)."
        ));
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
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager. HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new ItemCardAdapter(mealsArray,this));

        Intent myIntent = getIntent();
        Meals myMeal = (Meals) myIntent.getSerializableExtra("meal");
        mealName.setText(myMeal.getStrMeal());
        mealArea.setText(myMeal.getStrArea());
        Glide.with(this).load(myMeal.getStrMealThumb()).into(mealImage);
        getLifecycle().addObserver(youTubePlayerView);
      /* youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
           @Override
           public void onReady(@NonNull YouTubePlayer youTubePlayer) {
               super.onReady(youTubePlayer);
              String videoId="gXWXKjR-qII";
              youTubePlayer.loadVideo(videoId,0);
           }
       });*/



    }
}