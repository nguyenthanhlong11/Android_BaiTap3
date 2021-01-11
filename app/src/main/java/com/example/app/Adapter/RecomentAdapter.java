package com.example.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.FoodDetail;
import com.example.app.R;
import com.example.app.SQL.SQL;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;
import com.example.app.tabnavi;

import java.util.List;

public class RecomentAdapter extends RecyclerView.Adapter<RecomentAdapter.PopularViewHolder> {

    private Context context;
    private List<Recommended> recommendedList;

    public RecomentAdapter(Context context, List<Recommended> recommendedList) {
        this.context =  context;
        this.recommendedList = recommendedList;
    }



    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recoment, parent, false);
        PopularViewHolder popularViewHolder=new PopularViewHolder(view);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, final int position) {

        holder.recomentName.setText(recommendedList.get(position).getName());
        holder.recomentRate.setText(recommendedList.get(position).getRating());
        holder.recomentDeliver.setText(recommendedList.get(position).getDeliveryCharges());
        holder.recomentPrice.setText(recommendedList.get(position).getPrice());
        int id = context.getResources().getIdentifier(recommendedList.get(position).getImageUrl(), "drawable", context.getPackageName());
        holder.image.setImageDrawable(context.getResources().getDrawable(id));
//        holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.meo1));
//        Glide.with(context).load(recommendedList.get(position).getImageUrl()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("giao dien ", String.valueOf(recommendedList.get(position).getId()));
                Intent i = new Intent(context, FoodDetail.class);
                i.putExtra("id",String.valueOf(recommendedList.get(position).getId()));
                i.putExtra("name", recommendedList.get(position).getName());
                i.putExtra("price", recommendedList.get(position).getPrice());
                i.putExtra("rating", recommendedList.get(position).getRating());
                i.putExtra("image", recommendedList.get(position).getImageUrl());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView recomentName;
        TextView recomentPrice;
        TextView recomentRate;
        TextView recomentDeliver;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            recomentName = itemView.findViewById(R.id.txtNameRe);
            image = (ImageView) itemView.findViewById(R.id.imgRe);
            recomentDeliver=itemView.findViewById(R.id.txtDeliver);
            recomentRate=itemView.findViewById(R.id.txtRate);
            recomentPrice=itemView.findViewById(R.id.txtPr);

        }
    }
}
