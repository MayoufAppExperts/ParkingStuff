package com.example.theappexperts.parkingapp.SDI.module;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.example.theappexperts.parkingapp.MapsActivity;
import com.example.theappexperts.parkingapp.SDI.scope.ActivityContext;
import com.example.theappexperts.parkingapp.ui.parkingList.IParkingListMvpPresenter;
import com.example.theappexperts.parkingapp.ui.parkingList.IParkingListMvpView;
import com.example.theappexperts.parkingapp.ui.parkingList.ParkingListPresenter;
import com.example.theappexperts.parkingapp.ui.utils.rx.AppSchedulerProvider;
import com.example.theappexperts.parkingapp.ui.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by TheAppExperts on 03/10/2017.
 */

@Module
public class ActivityModule {

    FragmentActivity appCompatActivity;

    public ActivityModule(MapsActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    Context getContext(){
        return appCompatActivity;
    }

    @Provides
    FragmentActivity getAppCompatActivity(){
        return appCompatActivity;
    }

    @Provides
    CompositeDisposable getCompositeDisposable(){
        return  new CompositeDisposable();
    }

    @Provides
    SchedulerProvider getSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    /**
     * Presenter Objects
     * so far we returned the param
     */

    @Provides
    IParkingListMvpPresenter<IParkingListMvpView> iParkingListMvpPresenter(ParkingListPresenter<IParkingListMvpView> parkingListPresenter){
        return parkingListPresenter;

    }

}
