package com.example.foodplanner.ingrediant.ingredientView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class IngrediantAdapter extends RecyclerView.Adapter<IngrediantAdapter.MyHolder> {
    List<Ingredients> ingredientsArrayList;
    List<Ingredients> copy;

    Context context;
    public IngrediantAdapter(List<Ingredients> ingredientsList){
            ingredientsArrayList = ingredientsList;
            copy = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, null);
        MyHolder myViewHolder = new MyHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Ingredients ingredients = ingredientsArrayList.get(position);
        Log.i("photo", ingredients.getStrIngredient());
        String url = "https://www.themealdb.com/images/ingredients/"+ ingredients.getStrIngredient()+".png";
        Glide.with(context).load(url).into(holder.img);
        holder.txt.setText(ingredients.getStrIngredient());
    }
    public void setList(List<Ingredients>ingrdiant){
        ingredientsArrayList = ingrdiant;
        copy.addAll(ingrdiant);
    }

    @Override
    public int getItemCount() {
        return ingredientsArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView txt ;
        ImageView img ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txt =itemView.findViewById(R.id.Stext);
            img = itemView.findViewById(R.id.Simage);

        }
    }
    public void updateList(CharSequence s){

        ArrayList<Ingredients> searchArray=new ArrayList<>();
        if(s.length()>0){
            for(Ingredients name : copy){
                if(name.getStrIngredient().toLowerCase().startsWith(s.toString())) {
                    ingredientsArrayList.clear();
                    searchArray.add(name);
                    Log.i("TAG", "show data: " + name.getStrIngredient());
                }else
                    ingredientsArrayList.clear();

            }
            ingredientsArrayList.addAll(searchArray);
        }else {
            ingredientsArrayList.clear();
            ingredientsArrayList.addAll(copy);
        }
        notifyDataSetChanged();
        searchArray.clear();
    }
}
