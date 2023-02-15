package com.example.foodplanner.area.areaView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.area.areaModel.Area;

import java.util.ArrayList;
import java.util.List;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.MyHolder> {
    List<Area> areas;
    List<Area> copy;
    Context context;
    OnClick listner;
    private static ArrayList<Integer> flags ;
    public AreaAdapter(Context context, List<Area> areas, OnClick listner){
        this.context=context;
        this.listner=listner;
        this.areas = areas;
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
        Area area = areas.get(position);
        Log.i("area", area.getStrArea());
        Context context = holder.img.getContext();
        int id = context.getResources().getIdentifier(area.getStrArea().toLowerCase(), "drawable", context.getPackageName());
        holder.img.setImageResource(id);
        holder.txt.setText(area.getStrArea());
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.OnclickMeal(area);
            }
        });
    }

    @Override
    public int getItemCount() {
       return areas.size();
    }
    public void setList(List<Area>area){
        areas = area;
        copy.addAll(area);
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
    public void updateList(CharSequence s){

        ArrayList<Area> searchArray=new ArrayList<>();
        if(s.length()>0){
            for(Area name : copy){
                if(name.getStrArea().toLowerCase().startsWith(s.toString())) {
                    areas.clear();
                    searchArray.add(name);
                    Log.i("TAG", "show data: " + name.getStrArea());
                }else
                    areas.clear();

            }
            areas.addAll(searchArray);
        }else {
            areas.clear();
            areas.addAll(copy);
        }
        notifyDataSetChanged();
        searchArray.clear();
    }
}
