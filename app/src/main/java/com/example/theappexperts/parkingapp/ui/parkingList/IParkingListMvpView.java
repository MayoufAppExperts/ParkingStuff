package com.example.theappexperts.parkingapp.ui.parkingList;

import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 06/10/2017.
 */

public interface IParkingListMvpView extends MvpView {

    void onFetchDataCompleted(List<ParkingList>parkingList);

}
