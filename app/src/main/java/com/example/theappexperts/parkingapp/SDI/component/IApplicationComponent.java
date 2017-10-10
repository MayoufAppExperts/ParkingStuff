package com.example.theappexperts.parkingapp.SDI.component;

import android.app.Application;

import com.example.theappexperts.parkingapp.DataManager;
import com.example.theappexperts.parkingapp.MyApp;
import com.example.theappexperts.parkingapp.SDI.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TheAppExperts on 03/10/2017.
 */
//Component always interface
@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {
    void inject(MyApp app);

    Application getApplication();

    DataManager getDataManager();


}
