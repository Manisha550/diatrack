package com.example.diabiotrack;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diatrack.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        Button doctorsCheckupButton = findViewById(R.id.doctorsCheckupButton);
        Button loginButton = findViewById(R.id.loginButton);
        Button signupButton = findViewById(R.id.signupButton);
        Button emergencyButton = findViewById(R.id.emergencyButton);
        Button hotlineButton = findViewById(R.id.hotlineButton);

        // Nearby Hospitals RecyclerView
        RecyclerView hospitalsRecyclerView = findViewById(R.id.hospitalsRecyclerView);
        List<String> hospitalList = Arrays.asList(
                "Dhaka Medical College Hospital",
                "Apollo Hospitals Dhaka",
                "Square Hospitals Ltd.",
                "United Hospital Limited",
                "Bangladesh Specialized Hospital",
                "Labaid Hospital",
                "Holy Family Red Crescent Medical College Hospital",
                "Popular Diagnostic Center & Hospital",
                "Ibn Sina Hospital",
                "CMH Dhaka"
        );
        com.example.diabiotrack.HospitalAdapter adapter = new com.example.diabiotrack.HospitalAdapter(hospitalList, hospitalName ->
                Toast.makeText(MainActivity.this, "Selected: " + hospitalName, Toast.LENGTH_SHORT).show());
        hospitalsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        hospitalsRecyclerView.setAdapter(adapter);

        // Initialize Google Map
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                MainActivity.this.googleMap = googleMap;

                // Add sample hospital location
                LatLng hospitalLocation = new LatLng(23.8103, 90.4125); // Example: Dhaka, Bangladesh
                googleMap.addMarker(new MarkerOptions().position(hospitalLocation).title("Dhaka Medical College Hospital"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hospitalLocation, 12));
            }
        });

        // Button Click Listeners
        doctorsCheckupButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Doctors Checkup Clicked", Toast.LENGTH_SHORT).show());

        loginButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Login Clicked", Toast.LENGTH_SHORT).show());

        signupButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Sign Up Clicked", Toast.LENGTH_SHORT).show());

        emergencyButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Emergency Hospital Clicked", Toast.LENGTH_SHORT).show());

        hotlineButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Hotline Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDestroy();
        }
    }
}
