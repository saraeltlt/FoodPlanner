package com.example.foodplanner.detailsView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Ingredient;
import com.example.foodplanner.model.Meals;

import java.util.ArrayList;
import java.util.List;

public class IngredientsCardAdapter extends RecyclerView.Adapter<IngredientsCardAdapter.MealViewHolder> {
    private Meals meal;
    private Context context;
    private List<Ingredient> ingredientsList;

    public IngredientsCardAdapter(Meals meal, Context context) {
        this.meal = meal;
        this.context = context;
      ingredientsList= Ingredient.constructList(meal);

    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ingredient_card, parent , false);
        MealViewHolder vh = new MealViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Ingredient ingredient = ingredientsList.get(position);
        holder.text.setText(ingredient.getIngredientName());
        holder.count.setText(ingredient.getIngredientMeasure());
        String thumb = "https://www.themealdb.com/images/ingredients/"+ingredient.getIngredientName()+".png";
        Glide.with(context).load(thumb).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return ingredientsList.size();
    }


    public class MealViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView count;
        ImageView image;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            count= itemView.findViewById(R.id.count);
           text= itemView.findViewById(R.id.text);
            image= itemView.findViewById(R.id.image);


        }
    }
}