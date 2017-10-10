package com.example.theappexperts.parkingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//import com.example.theappexperts.parkingapp.SDI.component.DaggerIActivityComponent;
//import com.example.theappexperts.parkingapp.SDI.component.DaggerIActivityComponent;
import com.example.theappexperts.parkingapp.SDI.component.DaggerIActivityComponent;
import com.example.theappexperts.parkingapp.SDI.component.IActivityComponent;
import com.example.theappexperts.parkingapp.SDI.module.ActivityModule;
import com.example.theappexperts.parkingapp.network.model.ParkingList;
import com.example.theappexperts.parkingapp.ui.parkingList.IParkingListMvpView;
import com.example.theappexperts.parkingapp.ui.parkingList.ParkingListPresenter;
import com.example.theappexperts.parkingapp.ui.reserve.IResMvpView;
import com.example.theappexperts.parkingapp.ui.reserve.ResPresenter;
import com.example.theappexperts.parkingapp.ui.utils.rx.AppSchedulerProvider;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.function.LongFunction;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, IParkingListMvpView, IResMvpView {

    IActivityComponent iActivityComponent;
    List<ParkingList> parkingList;
    private GoogleMap mMap;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    ParkingListPresenter<IParkingListMvpView> iParkingListMvpViewParkingListPresenter;

    @Inject
    ResPresenter<IResMvpView> iResMvpViewResPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initialiseDagger();


        iParkingListMvpViewParkingListPresenter.onAttach(this);
        iParkingListMvpViewParkingListPresenter.onViewPrepared();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initialiseDagger() {

        iActivityComponent = DaggerIActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .iApplicationComponent(((MyApp) getApplication()).getiApplicationComponent())
                .build();

        getiActivityComponent().inject(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(parkingList));
    }

    @Override
    public void onFetchDataCompleted(List<ParkingList> parkingList) {
        Log.i("Complete", "loaded onfetch");
        double lng;
        double lat;

        for (int i = 0; i < parkingList.size(); i++) {

            lng = Double.parseDouble(parkingList.get(i).getLng());
            lat = Double.parseDouble(parkingList.get(i).getLat());
            LatLng parkingPlace = new LatLng(lat, lng);
            LatLng currentPlace = new LatLng(37.7749, 122.4194);
            //37.7749  122.4194
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPlace, 11));

            if (parkingList.get(i).getIsReserved()) {
                Log.d("Check reserve", "loaded");
                mMap.addMarker(new MarkerOptions()
                        .position(parkingPlace)
                        .title(String.valueOf(i))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            } else {
                mMap.addMarker(new MarkerOptions()
                        .position(parkingPlace)
                        .title(String.valueOf(i))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
            mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(parkingList));
//            int finalI = i;
//            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//                @Override
//                public void onInfoWindowClick(Marker marker) {
//                    Log.i("Infowindow", "Clicked");
//                    iResMvpViewResPresenter.onResPrepared();
//                    Log.i("Reserve check", parkingList.get(Integer.parseInt(marker.getTitle())).getIsReserved().toString());
//                    //marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//
//
////                    mMap.addMarker(new MarkerOptions()
////                            .position(parkingPlace)
////                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
//                }
//            });
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {
        Log.i("Error", message);

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onReserveCompleted(List<ParkingList> parkingList) {
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Log.i("blah", String.valueOf(parkingList.get(Integer.parseInt(marker.getId()))));
            }
        });

    }
}
