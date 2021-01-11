package com.example.app.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.model.Popular;
import com.example.app.R;

import java.util.List;

import static com.google.android.material.resources.MaterialResources.getDrawable;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private Context context;
    private List<Popular> popularList;

    public PopularAdapter(Context context, List<Popular> popularList) {
        this.context =  context;
        this.popularList = popularList;
    }



    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);
        PopularViewHolder popularViewHolder=new PopularViewHolder(view);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, final int position) {

        holder.popularName.setText(popularList.get(position).getName());


//        Glide.with(context).load(popularList.get(position).getImageUrl()).into(holder.image);
        Log.d("hinh anh: ",String.valueOf(popularList.get(position).getImageUrl()));
        int id = context.getResources().getIdentifier(popularList.get(position).getImageUrl(), "drawable", context.getPackageName());
        holder.image.setImageDrawable(context.getResources().getDrawable(id));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, FoodDetails.class);
//                i.putExtra("name", popularList.get(position).getName());
//                i.putExtra("price", popularList.get(position).getPrice());
//                i.putExtra("rating", popularList.get(position).getRating());
//                i.putExtra("image", popularList.get(position).getImageUrl());
//
//                context.startActivity(i);
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView popularName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.txNamepo);
            image = (ImageView) itemView.findViewById(R.id.imgPopular);

        }
    }
}
