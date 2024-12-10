package com.example.vacationtourapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapActivity extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configure osmdroid
        Configuration.getInstance().setUserAgentValue(getPackageName());

        // Set the layout
        setContentView(R.layout.activity_map);

        // Initialize MapView
        mapView = findViewById(R.id.mapView);
        mapView.setMultiTouchControls(true);

        // Set default map view to Tunisia
        mapView.getController().setZoom(6.0);
        mapView.getController().setCenter(new GeoPoint(34.0, 9.0));

        // Add a marker for Tunis
        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(36.8065, 10.1815));
        marker.setTitle("Tunis - Capital of Tunisia");
        mapView.getOverlays().add(marker);

        // Set up the "Center Map" button
        findViewById(R.id.centerMapButton).setOnClickListener(v -> {
            mapView.getController().setCenter(new GeoPoint(34.0, 9.0));
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDetach();
        }
    }
}
