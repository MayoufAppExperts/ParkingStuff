package com.example.theappexperts.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TheAppExperts on 09/10/2017.
 */

class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    public View customView;
    List<ParkingList> parkingList;

    @BindView(R.id.parkID)
    TextView tvId;
    @BindView(R.id.parkName)
    TextView tvName;
    @BindView(R.id.costPerMin)
    TextView tvCostPerMin;
    @BindView(R.id.isReserved)
    TextView tvReserved;
    @BindView(R.id.minReserve)TextView tvMinReserve;
    @BindView(R.id.maxReserve)TextView tvMaxReserve;
    @BindView(R.id.reservedUntil)TextView tvReservedUntil;

    public CustomInfoWindowAdapter(List<ParkingList> parkingList) {
        customView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.custom_view, null);
        this.parkingList=parkingList;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        ButterKnife.bind(this, customView);

        tvId.setText("Parking ID " + parkingList.get(Integer.parseInt(marker.getTitle())).getId().toString());
        tvName.setText("Name "+parkingList.get(Integer.parseInt(marker.getTitle())).getName());
        tvCostPerMin.setText("Cost per min" + parkingList.get(Integer.parseInt(marker.getTitle())).getCostPerMinute());
        tvReserved.setText("Is reserved: "+parkingList.get(Integer.parseInt(marker.getTitle())).getIsReserved().toString());
        tvMinReserve.setText("Min Reserve"+parkingList.get(Integer.parseInt(marker.getTitle())).getMinReserveTimeMins().toString());
        tvMaxReserve.setText("Max Reserve"+parkingList.get(Integer.parseInt(marker.getTitle())).getMaxReserveTimeMins().toString());
        tvReservedUntil.setText("Reserved until"+parkingList.get(Integer.parseInt(marker.getTitle())).getReservedUntil());
        return customView;
    }
}
