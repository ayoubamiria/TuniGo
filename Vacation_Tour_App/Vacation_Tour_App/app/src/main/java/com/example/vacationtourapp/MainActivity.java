package com.example.vacationtourapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacationtourapp.adapter.RecentsAdapter;
import com.example.vacationtourapp.adapter.TopPlacesAdapter;
import com.example.vacationtourapp.model.RecentsData;
import com.example.vacationtourapp.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigate to ProfileActivity when profile icon is clicked
        ImageView profileIcon = findViewById(R.id.profileicon);
        profileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Navigate to ChatbotActivity when chatbot icon is clicked
        ImageView chatbotIcon = findViewById(R.id.chatbot_icon);
        chatbotIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChatbotActivity.class);
            startActivity(intent);
        });
        // Navigate to MapActivity when flights icon is clicked
        ImageView flightsIcon = findViewById(R.id.flights);
        flightsIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intent);
        });


        // Now here we will add some dummy data in our model class

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Bizerte","Bizerte Governorate","",R.drawable.img00));
        recentsDataList.add(new RecentsData("Sidi Bou Said","Tunis Governorate","",R.drawable.img33));
        recentsDataList.add(new RecentsData("El Djem"," Mahdia Governorate","",R.drawable.img44));
        recentsDataList.add(new RecentsData("Port El Kantaoui","Sousse Governorate","",R.drawable.img55));
        recentsDataList.add(new RecentsData("Beja","Beja Governorate","",R.drawable.img999));
        recentsDataList.add(new RecentsData("Matmata","Gabés Governorate","",R.drawable.img77));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Menzel Temime","Nabeul Governorate","",R.drawable.img22));
        topPlacesDataList.add(new TopPlacesData("Karkanah ","Sfax Governorate","",R.drawable.img88));
        topPlacesDataList.add(new TopPlacesData("El Djem","Mahdia Governorate","",R.drawable.img44));
        topPlacesDataList.add(new TopPlacesData("Douz","Kebili Governorate","",R.drawable.img66));
        topPlacesDataList.add(new TopPlacesData("Nabeul","Nabeul Governorate","",R.drawable.img11));

        setTopPlacesRecycler(topPlacesDataList);
    }

    // Set up the RecyclerView for Recent places
    private void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }

    // Set up the RecyclerView for Top places
    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){
        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
    }
}
