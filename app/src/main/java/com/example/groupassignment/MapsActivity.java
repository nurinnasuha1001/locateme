package com.example.groupassignment;

[20:03, 07/02/2025] wida inani cs240: import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Initialize map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker and move the camera
        LatLng uitmMachang = new LatLng(5.7619, 102.2450);

        // Add a marker at UiTM Machang and move the camera
        mMap.addMarker(new MarkerOptions().position(uitmMachang).title("Marker at UiTM Machang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uitmMachang, 15)); // Zoom level adjusted for better view
    }
}