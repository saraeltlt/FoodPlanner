
package com.example.foodplanner.home.homeView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.foodplanner.UI.HomeActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.mealModel.Meal;

import java.util.List;

public class HomeMealAdapter extends RecyclerView.Adapter<HomeMealAdapter.MealViewHolder> {
    private List<Meal> mealsArrayList;
    private Context context;
    private OnClickMealHome listener;
    private ViewPager2 viewPager2;


    public HomeMealAdapter(List<Meal> mealsArrayList, Context context, OnClickMealHome listener, ViewPager2 viewPager2) {
        this.mealsArrayList = mealsArrayList;
        this.context = context;
        this.listener = listener;
        this.viewPager2=viewPager2;
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
        View view = inflater.inflate(R.layout.meal_card_home, parent , false);
        MealViewHolder vh = new MealViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {

        Meal meal= mealsArrayList.get(position);

        if (meal.getMealAddedToFav()) {
            holder.favBtn.setImageResource(R.drawable.favorite_red);
        }
        else{
            holder.favBtn.setImageResource(R.drawable.favorite_white);
        }
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
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeActivity.getGuestFlag()){
                    Toast.makeText(context, R.string.access, Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!meal.getMealAddedToFav()) {
                        holder.favBtn.setImageResource(R.drawable.favorite_red);
                        listener.onClickAddFav(meal);
                        meal.setMealAddedToFav(true);
                    } else {
                        holder.favBtn.setImageResource(R.drawable.favorite_white);
                        listener.onClickRemoveFav(meal);
                        meal.setMealAddedToFav(false);

                    }
                }
            }
        });
        if (position== mealsArrayList.size()-2){
            viewPager2.post(runnable);
        }

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
        ImageButton favBtn;
       ConstraintLayout layout;
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            meal = itemView.findViewById(R.id.meal);
           area = itemView.findViewById(R.id.area);
           image = itemView.findViewById(R.id.card);
           layout=itemView.findViewById(R.id.layout);
           favBtn=itemView.findViewById(R.id.addFav);
           flag = itemView.findViewById(R.id.areaFlag);

        }
    }
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
        mealsArrayList.addAll(mealsArrayList);
        notifyDataSetChanged();
    }
};

}
