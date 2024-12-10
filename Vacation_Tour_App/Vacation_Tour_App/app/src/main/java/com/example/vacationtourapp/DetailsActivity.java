package com.example.vacationtourapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Retrieve data from the Intent
        String placeName = getIntent().getStringExtra("placeName");
        String countryName = getIntent().getStringExtra("countryName");
        String price = getIntent().getStringExtra("price");
        Integer imageUrl = getIntent().getIntExtra("imageUrl", -1);

        // Set data to the corresponding views
        TextView placeNameTextView = findViewById(R.id.textView6);
        TextView countryNameTextView = findViewById(R.id.textView7);
        TextView priceTextView = findViewById(R.id.textView11);
        ImageView placeImageView = findViewById(R.id.imageView8);

        placeNameTextView.setText(placeName);
        countryNameTextView.setText(countryName);
        priceTextView.setText(price);
        placeImageView.setImageResource(imageUrl);

        // Back arrow functionality
        ImageView backArrow = findViewById(R.id.imageView4);
        backArrow.setOnClickListener(view -> finish()); // Close the activity when back arrow is clicked

        // "Know More About This Place" button functionality
        Button knowMoreButton = findViewById(R.id.button);
        knowMoreButton.setOnClickListener(view -> {
            Intent intent = new Intent(DetailsActivity.this, MoreOptionsActivity.class);
            intent.putExtra("placeName", placeName); // Pass placeName if needed
            startActivity(intent);
        });
    }
}
