package com.example.foodplanner.category.categoryView;

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
import com.example.foodplanner.model.Area;
import com.example.foodplanner.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {
    List<Category> categories;
    List<Category>copy;
    Context context;
    public CategoryAdapter(List<Category> categoryList){
        categories = categoryList;
        copy=new ArrayList<>();
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
        copy.addAll(categoryList);
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
    public void updateList(CharSequence s){
        ArrayList<Category> searchArray=new ArrayList<>();
        if(s.length()>0){
            for(Category name : copy){
                if(name.getStrCategory().toLowerCase().startsWith(s.toString())) {
                    categories.clear();
                    searchArray.add(name);
                    Log.i("TAG", "show data: " + name.getStrCategory());
                }else
                    categories.clear();

            }
            categories.addAll(searchArray);
        }else {
            categories.clear();
            categories.addAll(copy);
        }
        notifyDataSetChanged();
        searchArray.clear();
    }
}
