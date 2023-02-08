package com.example.foodplanner.ingrediantView;

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
import com.example.foodplanner.model.Ingrd;

import java.util.List;

public class IngrediantAdapter extends RecyclerView.Adapter<IngrediantAdapter.MyHolder> {
    List<Ingrd> ingrdArrayList;
    Context context;
    public IngrediantAdapter(List<Ingrd> ingrdList){
            ingrdArrayList = ingrdList;
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
        Ingrd ingrd = ingrdArrayList.get(position);
        Log.i("photo", ingrd.getTitle());
        String url = "https://www.themealdb.com/images/ingredients/"+ingrd.getTitle()+".png";
        Glide.with(context).load(url).into(holder.img);
        holder.txt.setText(ingrd.getTitle());
    }
    public void setList(List<Ingrd>ingrdiant){
        ingrdArrayList = ingrdiant;
    }

    @Override
    public int getItemCount() {
        return ingrdArrayList.size();
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
}
