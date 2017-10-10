package com.example.theappexperts.parkingapp;

import android.util.Log;
import android.widget.Toast;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

/**
 * Created by TheAppExperts on 09/10/2017.
 */

class WindowClickListener implements GoogleMap.OnInfoWindowClickListener {

    List<ParkingList> parkingList;

    public WindowClickListener(List<ParkingList> parkingList) {
        this.parkingList=parkingList;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.d("Check", "Clicked");
        Toast.makeText(MyApp.getContext(), "Info Window Clicked", Toast.LENGTH_LONG).show();

    }
}
