package com.example.foodplanner.regionView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.ingrediantView.IngrediantAdapter;
import com.example.foodplanner.model.Area;
import com.example.foodplanner.model.Ingrd;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.MyHolder> {
    List<Area> areas;
    Context context;
    private static ArrayList<Integer> flags ;
    public RegionAdapter(List<Area> areas){
        this.areas = areas;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, null);
        //fill_arrayList();
        MyHolder myViewHolder = new MyHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Area area = areas.get(position);
        Log.i("area", area.getRegion());
        Context context = holder.img.getContext();
        int id = context.getResources().getIdentifier(area.getRegion().toLowerCase(), "drawable", context.getPackageName());
        holder.img.setImageResource(id);
        holder.txt.setText(area.getRegion());
    }

    @Override
    public int getItemCount() {
       return areas.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView txt ;
        ImageView img ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txt =itemView.findViewById(R.id.Stext);
            img = itemView.findViewById(R.id.Simage);

        }
    }
}
