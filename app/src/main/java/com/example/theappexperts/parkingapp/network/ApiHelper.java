package com.example.theappexperts.parkingapp.network;

import com.example.theappexperts.parkingapp.network.model.ParkingList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 06/10/2017.
 */

public interface ApiHelper {
    Observable<List<ParkingList>> useCaseParkingList();
    Observable<ParkingList> useCaseRes();
}
