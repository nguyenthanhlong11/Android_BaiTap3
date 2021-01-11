package com.example.app.retrofit;

import com.example.app.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  ApiInterface {
    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}
