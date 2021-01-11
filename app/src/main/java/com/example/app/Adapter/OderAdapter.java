package com.example.app.Adapter;

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
import com.example.app.Object.cart;
import com.example.app.R;
import com.example.app.model.Recommended;
import com.example.app.tabnavi;

import java.util.List;

public class OderAdapter extends RecyclerView.Adapter<OderAdapter.OderViewHolder> {
    private Context context;
    private List<cart> cartList;
    private List<Recommended> recommendedList;

    public OderAdapter(Context context, List<cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    public OderAdapter(Context context, List<cart> cartList, List<Recommended> recommendedList) {
        this.context = context;
        this.cartList = cartList;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public OderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false);

        return new OderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OderViewHolder holder, int position) {
        holder.oderName.setText(recommendedList.get(cartList.get(position).getIdPro()-1).getName());
        holder.OderPrice.setText(recommendedList.get(cartList.get(position).getIdPro()-1).getPrice());
        holder.oderQuanlity.setText(String.valueOf(cartList.get(position).getQuanlity()));

        int id = context.getResources().getIdentifier(recommendedList.get(cartList.get(position).getIdPro()-1).getImageUrl(), "drawable", context.getPackageName());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(id));
//        Glide.with(context).load(recommendedList.get(cartList.get(position).getIdPro()-1).getImageUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabnavi.sql.delete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cartList.size();
    }

    public class OderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView oderName, OderPrice, oderQuanlity;
        public OderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgcart);
            oderName=itemView.findViewById(R.id.txNameCart);
            oderQuanlity=itemView.findViewById(R.id.quanlity);
            OderPrice=itemView.findViewById(R.id.txtpriceOder);
        }
    }
}
