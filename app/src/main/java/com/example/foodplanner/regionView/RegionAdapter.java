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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_card, null);
        fill_arrayList();
        MyHolder myViewHolder = new MyHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Area area = areas.get(position);
        Log.i("area", area.getRegion());
        holder.img.setImageResource(flags.get(position));
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
            txt =itemView.findViewById(R.id.areaTxt);
            img = itemView.findViewById(R.id.areaImg);

        }
    }
    private static void fill_arrayList(){
        flags = new ArrayList<>();
        flags.add(R.drawable.american);
        flags.add(R.drawable.british);
        flags.add(R.drawable.canadian);
        flags.add(R.drawable.china);
        flags.add(R.drawable.corwatia);
        flags.add(R.drawable.dutch);
        flags.add(R.drawable.egypt);
        flags.add(R.drawable.france);
        flags.add(R.drawable.greece);
        flags.add(R.drawable.india);
        flags.add(R.drawable.ireland);
        flags.add(R.drawable.italy);
        flags.add(R.drawable.jamaica);
        flags.add(R.drawable.japan);
        flags.add(R.drawable.kienia);
        flags.add(R.drawable.malysia);
        flags.add(R.drawable.mixico);
        flags.add(R.drawable.marroc);
        flags.add(R.drawable.polish);
        flags.add(R.drawable.portugal);
        flags.add(R.drawable.russia);
        flags.add(R.drawable.spain);
        flags.add(R.drawable.tail);
        flags.add(R.drawable.tunisia);
        flags.add(R.drawable.turkich);
        flags.add(R.drawable.vietnam);
    }
}
