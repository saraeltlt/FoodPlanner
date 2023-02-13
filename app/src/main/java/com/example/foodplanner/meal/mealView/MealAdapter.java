package com.example.foodplanner.meal.mealView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;

import com.example.foodplanner.home.homeView.OnClickMealHome;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public class MealAdapter  extends RecyclerView.Adapter<MealAdapter.MealViewHolder>{
    private List<Meal> mealsArrayList;
    private Context context;
    private OnClickMealHome listener;

    public MealAdapter(List<Meal> mealsArrayList, Context context, OnClickMealHome listener) {
        this.mealsArrayList = mealsArrayList;
        this.context = context;
        this.listener = listener;
    }

    public List<Meal> getMealsArrayList() {
        return mealsArrayList;
    }

    public void setMealsArrayList(List<Meal> mealsArrayList) {
        this.mealsArrayList = mealsArrayList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.meal_card_search, parent , false);
        MealViewHolder vh = new MealViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal= mealsArrayList.get(position);
        holder.meal.setText(meal.getStrMeal());
        holder.area.setText(meal.getStrArea());
        Context contextImage = holder.flag.getContext();
        int id = contextImage .getResources().getIdentifier(meal.getStrArea().toLowerCase(), "drawable", contextImage.getPackageName());
        holder.flag.setImageResource(id);

        Glide.with(context).load(meal.getStrMealThumb()).into(holder.image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickDetails(meal);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        TextView meal;
        TextView area;
        ImageView image;
        ImageView flag;
        ConstraintLayout layout;
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            meal = itemView.findViewById(R.id.searchMeal);
            area = itemView.findViewById(R.id.searchArea);
            image = itemView.findViewById(R.id.searchImage);
            layout=itemView.findViewById(R.id.searchLayout);
            flag = itemView.findViewById(R.id.searchAreaFlag);

        }
    }
}
