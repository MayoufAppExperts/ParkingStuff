package com.example.theappexperts.parkingapp.ui.parkingList;

import com.example.theappexperts.parkingapp.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 06/10/2017.
 */

public interface IParkingListMvpPresenter <V extends IParkingListMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
