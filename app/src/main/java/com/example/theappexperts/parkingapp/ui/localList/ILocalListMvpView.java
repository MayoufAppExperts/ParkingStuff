package com.example.theappexperts.parkingapp.ui.localList;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 09/10/2017.
 */

public interface ILocalListMvpView extends MvpView{

    void onLocalDataCompleted(List<ParkingList> localList);
}
