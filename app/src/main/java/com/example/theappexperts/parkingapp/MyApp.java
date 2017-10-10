package com.example.theappexperts.parkingapp;

import android.app.Application;
import android.content.Context;

import com.example.theappexperts.parkingapp.SDI.component.DaggerIApplicationComponent;
import com.example.theappexperts.parkingapp.SDI.component.IApplicationComponent;
import com.example.theappexperts.parkingapp.SDI.module.ApplicationModule;

/**
 * Created by kalpesh on 27/09/2017.
 */

public class MyApp extends Application {


    public static Application sApplication;

    IApplicationComponent iApplicationComponent;

    public IApplicationComponent getiApplicationComponent() {
        return iApplicationComponent;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        iApplicationComponent= DaggerIApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        getiApplicationComponent().inject(this);
    }

}
