package com.example.vacationtourapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacationtourapp.adapter.RestaurantAdapter;
import com.example.vacationtourapp.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);  // Set the appropriate layout

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.rv_restaurants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create and populate the list of restaurants
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Le Club", "Un restaurant offrant une cuisine méditerranéenne et des fruits de mer.", R.drawable.mm1));
        restaurantList.add(new Restaurant("La Marmite", "Célèbre pour ses plats tunisiens authentiques.", R.drawable.mm2));
        restaurantList.add(new Restaurant("Le Maillot Rouge", "Une adresse idéale pour les amateurs de poisson frais.", R.drawable.mm3));
        restaurantList.add(new Restaurant("Dar El Kasbah", "Restaurant situé au cœur de la médina.", R.drawable.mm4));
        restaurantList.add(new Restaurant("Café Cheikh", "Un lieu parfait pour un thé avec une vue sur le vieux port.", R.drawable.mm5));

        // Initialize the adapter
        restaurantAdapter = new RestaurantAdapter(restaurantList);
        recyclerView.setAdapter(restaurantAdapter);
    }
}
