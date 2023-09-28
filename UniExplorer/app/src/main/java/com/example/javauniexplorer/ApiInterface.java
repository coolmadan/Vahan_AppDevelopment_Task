package com.example.javauniexplorer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/search")
    Call<List<UniModel>> getUni();
}
