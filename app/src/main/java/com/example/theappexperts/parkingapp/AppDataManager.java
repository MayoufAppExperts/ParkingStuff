package com.example.theappexperts.parkingapp;

import android.content.Context;

import com.example.theappexperts.parkingapp.SDI.scope.ApplicationContext;
import com.example.theappexperts.parkingapp.network.ApiHelper;
import com.example.theappexperts.parkingapp.network.model.ParkingList;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 06/10/2017.
 */
@Singleton
public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    @Override
    public Observable<List<ParkingList>> useCaseParkingList() {
        return apiHelper.useCaseParkingList();
    }

    @Override
    public Observable<ParkingList> useCaseRes() {
        return apiHelper.useCaseRes();
    }
}
