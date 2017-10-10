package com.example.theappexperts.parkingapp.network;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.network.service.ConnectionService;
import com.example.theappexperts.parkingapp.network.service.ReqInterface;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 06/10/2017.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private ReqInterface reqInterface;

    @Inject
    public AppApiHelper() {
        this.reqInterface = ConnectionService.getConnectionService();
    }

    @Override
    public Observable<List<ParkingList>> useCaseParkingList() {
        return reqInterface.getParking();
    }

    @Override
    public Observable<ParkingList> useCaseRes() {
        return reqInterface.getReserve();
    }
}
