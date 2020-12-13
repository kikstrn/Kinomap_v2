package com.example.kinomap;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class ViewVehicle extends AppCompatActivity {
    //private Context context;
    private RecyclerView recyclerView;
    //private Vehicles vc;
    private ArrayList<Vehicles> data;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_vehicles);
        initViews();

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.listVehicles);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadJSON();
    }

    public interface RequestInterface {

        @GET("/")
        Call<Vehicles.JSONResponse> getJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.kinomap.com/vehicle/list?icon=1&lang=en-gb&forceStandard=1&outputFormat=json&appToken=8qohg5a9c6q6x58szpyxizvp91yary3setxdxutl10dugtel1syjs6gmrp33oo40a356j2cxt6vdcpzg095drsym5blnyen0hi4bdq32j61clfux2i9vtuhr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<Vehicles.JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<Vehicles.JSONResponse>() {
            @Override
            public void onResponse(Call<Vehicles.JSONResponse> call, Response<Vehicles.JSONResponse> response) {

                Vehicles.JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getVehicles()));
                adapter = new RecyclerViewAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Vehicles.JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

}





        //private List<Vehicles> genererVehicule()
        //{
        //List<Vehicles> vehicles = new ArrayList<>();
        //vehicles.add(new Vehicles(1, "test1"));
        //vehicles.add(new Vehicles(2,  "test2"));
        //vehicles.add(new Vehicles(3, "test3"));
        //vehicles.add(new Vehicles(4,  "test4"));
        //vehicles.add(new Vehicles(5,  "test5"));
        //if(vc != null)
        //{
        //vehicles.add(vc);
        //}
        //return vehicles;

        //}


        //private void affichage(){
        //List<Vehicles> vh = genererVehicule();
        //RecyclerViewAdapter rva = new RecyclerViewAdapter(context, vh, ViewVehicle.this);
        //recyclerView.setAdapter(rva);
        //}


        //@Override
        //public void itemClick(int position) {

        //}


