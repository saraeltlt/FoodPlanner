package com.example.foodplanner.searchResult.searchResultView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MealViewHolder>{
    private List<Meal> mealsArrayList;
    private Context context;
    private OnClick listener;

    public SearchResultAdapter(List<Meal> mealsArrayList, Context context, OnClick listener) {
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
        View view = inflater.inflate(R.layout.search_card, parent , false);
        MealViewHolder vh = new MealViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal= mealsArrayList.get(position);
        holder.meal.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).into(holder.image);
        holder.meal.setOnClickListener(new View.OnClickListener() {
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
        ImageView image;
        ConstraintLayout layout;
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            meal = itemView.findViewById(R.id.Stext);
            image = itemView.findViewById(R.id.Simage);
            layout=itemView.findViewById(R.id.layout);


        }
    }
}
