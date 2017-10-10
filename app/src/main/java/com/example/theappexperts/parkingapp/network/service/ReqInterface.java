package com.example.theappexperts.parkingapp.network.service;

import com.example.theappexperts.parkingapp.network.model.API_Constants;
import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.google.android.gms.common.api.Api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by TheAppExperts on 06/10/2017.
 */

public interface ReqInterface {
    @GET(API_Constants.BASE_URL) Observable<List<ParkingList>> getParking();
    @GET(API_Constants.MY_URL)Observable<List<ParkingList>> getLocal();
    @POST(API_Constants.RES_URL)Observable<ParkingList> getReserve();
}
