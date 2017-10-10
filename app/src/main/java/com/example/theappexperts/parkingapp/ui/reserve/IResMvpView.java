package com.example.theappexperts.parkingapp.ui.reserve;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 09/10/2017.
 */

public interface IResMvpView extends MvpView {

    void onReserveCompleted(List<ParkingList>parkingList);
}
