package com.example.foodplanner.detailsView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

import java.util.List;

public class RecipeCardAdapter extends RecyclerView.Adapter<RecipeCardAdapter.MealViewHolder> {
    private List<String> recipe;
    private Context context;

    public RecipeCardAdapter(List<String>  recipe, Context context) {
        this.recipe = recipe;
        this.context = context;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recipe_card, parent , false);
        MealViewHolder vh = new MealViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        String recipeStep= recipe.get(position);
        holder.step.setText(recipeStep);
        int step=position+1;
        holder.stepNum.setText("Step "+step+":");
    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }


    public class MealViewHolder extends RecyclerView.ViewHolder {

        TextView step;
        TextView stepNum;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            step= itemView.findViewById(R.id.step);
            stepNum= itemView.findViewById(R.id.stepNum);


        }
    }
}



