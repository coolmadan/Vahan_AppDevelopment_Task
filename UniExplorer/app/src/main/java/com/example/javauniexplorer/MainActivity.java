package com.example.javauniexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static String api ="http://universities.hipolabs.com";

    List<UniModel>allUniList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //GET  /search
        RetrofitInstance.getInstance().apiInterface.getUni().enqueue(new Callback<List<UniModel>>() {
            @Override
            public void onResponse(Call<List<UniModel>> call, Response<List<UniModel>> response) {
                allUniList=response.body();

                recyclerView.setAdapter(new newUniAdapter(MainActivity.this,allUniList));
            }

            @Override
            public void onFailure(Call<List<UniModel>> call, Throwable t) {
                Log.e("api","onFailure:"+t.getLocalizedMessage());
            }
        });

    }
}