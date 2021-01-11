package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.app.Object.cart;
import com.example.app.SQL.SQL;

public class FoodDetail extends AppCompatActivity {

    ImageView imageView;
    TextView itemName, itemPrice,itemRating;

    int id;
    String name, price, rating, imageUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.pet_details);
        Intent intent = getIntent();

        Log.d("btn", intent.getStringExtra("id"));
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");


        imageView = findViewById(R.id.imgDetais);
        itemName = findViewById(R.id.txtNamedetals);
        itemPrice = findViewById(R.id.txtPriceDe);
        itemRating = findViewById(R.id.rating);
//        ratingBar = findViewById(R.id.ratingBar);
//
//        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        int id = this.getResources().getIdentifier(imageUrl, "drawable", this.getPackageName());
        imageView.setImageDrawable(this.getResources().getDrawable(id));
//
        itemName.setText(name);
        itemPrice.setText(price+"$");
//        itemRating.setText(rating);
        itemRating.setText(rating);
//        ratingBar.setRating(Float.parseFloat(rating));
        SQL sql= new SQL(FoodDetail.this);
        Button btn=findViewById(R.id.btnOder);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cart cart=new cart(Integer.valueOf(intent.getStringExtra("id")),1);
                sql.addCart(cart);
                Log.d("Đặt hàng","thành công");
            }
        });
    }
}
