package com.example.foodplanner.categoryView;

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
import com.example.foodplanner.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {
    List<Category> categories;
    Context context;
    public CategoryAdapter(List<Category> categoryList){
        categories = categoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, null);
        MyHolder myViewHolder = new MyHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyHolder holder, int position) {
        Category category = categories.get(position);
        Log.i("photo", category.getStrCategory()+"->"+category.getStrCategoryThumb());
        Glide.with(context).load(category.getStrCategoryThumb()).into(holder.img);
        holder.txt.setText(category.getStrCategory());
    }
    public void setList(List<Category>categoryList){
        categories = categoryList;
    }

    @Override
    public int getItemCount() {
        return categories.size();
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
