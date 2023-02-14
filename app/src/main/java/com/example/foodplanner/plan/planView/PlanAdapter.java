package com.example.foodplanner.plan.planView;

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
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {
    private List<Meal> mealsArrayList;
    private Context context;
    private OnClickPlan listener;

    public PlanAdapter(Context context,List<Meal> mealsArrayList,  OnClickPlan listener) {
        this.mealsArrayList = mealsArrayList;
        this.context = context;
        this.listener = listener;
    }

    public List<Meal> getMealsArrayList() {
        return mealsArrayList;
    }

    public void setMealsArrayList(List<Meal> mealsArrayList) {
        this.mealsArrayList = mealsArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.plan_card, parent , false);
        PlanViewHolder vh = new PlanViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
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
                meal.setMealAddedToFav(true);
                listener.onClickDetails(meal);
            }
        });
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickRemove(meal);
                meal.setMealAddedToFav(false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {
        TextView meal;
        TextView area;
        ImageView image;
        ImageButton favBtn;
        ImageView flag;
        ConstraintLayout layout;
        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            meal = itemView.findViewById(R.id.meal);
            area = itemView.findViewById(R.id.area);
            image = itemView.findViewById(R.id.image);
            layout=itemView.findViewById(R.id.layout);
            favBtn=itemView.findViewById(R.id.addFav);
            flag = itemView.findViewById(R.id.areaFlag);

        }
    }
}


