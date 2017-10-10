/*
package com.example.theappexperts.parkingapp.ui.reserve;

import com.example.theappexperts.parkingapp.DataManager;
import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.base.BasePresenter;
import com.example.theappexperts.parkingapp.ui.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

*/
/**
 * Created by TheAppExperts on 09/10/2017.
 *//*


public class ResPresenter
    <V extends IResMvpView>
    extends BasePresenter<V>
    implements IResMvpPresenter<V>{


    @Inject
    public ResPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onResPrepared() {
        getCompositeDisposable().add(getDataManager()
                .useCaseRes()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ParkingList>>() {
                               @Override
                               public void accept(@NonNull List<ParkingList> parkingLists) throws Exception {
                                   getMvpView().onReserveCompleted(parkingLists);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                getMvpView().onError(throwable.getMessage());
                            }
                        }));

    }
}
*/
