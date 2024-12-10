package com.example.vacationtourapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacationtourapp.adapter.MonumentAdapter;
import com.example.vacationtourapp.model.Monument;

import java.util.ArrayList;
import java.util.List;

public class MonumentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MonumentAdapter monumentAdapter;
    private List<Monument> monumentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments);  // Set the appropriate layout

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.rv_monuments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create and populate the list of monuments
        monumentList = new ArrayList<>();
        monumentList.add(new Monument("Fort of Espagne", "A site with an exceptional panoramic view of the city and the sea.", R.drawable.kk1));
        monumentList.add(new Monument("Médina of Bizerte", "Discover its traditional architecture and souks.", R.drawable.kk2));
        monumentList.add(new Monument("Kasbah of Bizerte", "An ancient fortress rich in history.", R.drawable.kk3));
        monumentList.add(new Monument("Archaeological Site of Utica", "Nearby, explore this fascinating Roman site.", R.drawable.kk4));
        monumentList.add(new Monument("Movable bridge", "A modern and functional icon of the city.", R.drawable.kk5));
        monumentList.add(new Monument("The northernmost point", "Cap Blanc is a cape in northern Tunisia.", R.drawable.kk6));
        monumentList.add(new Monument("Martyrs' Cemetery in Bizerte", "An ancient Cemetery full of history.", R.drawable.kk7));

        // Initialize the adapter
        monumentAdapter = new MonumentAdapter(monumentList);
        recyclerView.setAdapter(monumentAdapter);
    }
}
