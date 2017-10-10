package com.example.theappexperts.parkingapp.ui.parkingList;

import com.example.theappexperts.parkingapp.DataManager;
import com.example.theappexperts.parkingapp.network.model.API_Constants;
import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.base.BasePresenter;
import com.example.theappexperts.parkingapp.ui.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TheAppExperts on 06/10/2017.
 */

public class ParkingListPresenter
        <V extends IParkingListMvpView>
        extends BasePresenter<V>
        implements IParkingListMvpPresenter<V> {

    @Inject
    public ParkingListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable().add(getDataManager()
                .useCaseParkingList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ParkingList>>() {
                               @Override
                               public void accept(@NonNull List<ParkingList> parkingLists) throws Exception {
                                   getMvpView().onFetchDataCompleted(parkingLists);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {

                            }
                        }));
    }
}
