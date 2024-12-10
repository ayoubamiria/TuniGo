package com.example.vacationtourapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MoreOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);

        // Set onClickListeners for each card
        findViewById(R.id.hotelsCard).setOnClickListener(v -> {
            // Navigate to Hotels Page
            Intent intent = new Intent(MoreOptionsActivity.this, HotelsActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.monumentsCard).setOnClickListener(v -> {
            // Navigate to Monuments Page
            Intent intent = new Intent(MoreOptionsActivity.this, MonumentsActivity.class);
           startActivity(intent);
        });

        findViewById(R.id.restaurantsCard).setOnClickListener(v -> {
            // Navigate to Restaurants Page
            Intent intent = new Intent(MoreOptionsActivity.this, RestaurantsActivity.class);
           startActivity(intent);
        });
    }
}
