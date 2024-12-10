package com.example.vacationtourapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacationtourapp.adapter.HotelAdapter;
import com.example.vacationtourapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotelAdapter hotelAdapter;
    private List<Hotel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        recyclerView = findViewById(R.id.rv_hotels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data (Replace with actual data)
        hotelList = new ArrayList<>();
        hotelList.add(new Hotel("Hotel Bizerta Resort", "Un complexe 4 étoiles avec vue sur la mer.", R.drawable.ee1));
        hotelList.add(new Hotel("Hotel Andalucia", "Idéal pour les voyageurs recherchant confort et proximité du centre-ville.", R.drawable.ee2));
        hotelList.add(new Hotel("Hotel Nour", "Hôtel moderne avec une ambiance conviviale.", R.drawable.ee3));
        hotelList.add(new Hotel("Hotel Corniche Palace ", "Un hôtel situé près des plages.", R.drawable.ee4));

        hotelAdapter = new HotelAdapter(hotelList);
        recyclerView.setAdapter(hotelAdapter);
    }
}
