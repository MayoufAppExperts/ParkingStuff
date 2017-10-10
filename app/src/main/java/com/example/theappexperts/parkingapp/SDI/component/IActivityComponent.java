package com.example.theappexperts.parkingapp.SDI.component;


import com.example.theappexperts.parkingapp.MapsActivity;
import com.example.theappexperts.parkingapp.SDI.module.ActivityModule;
import com.example.theappexperts.parkingapp.SDI.scope.PerActivity;

import dagger.Component;

/**
 * Created by TheAppExperts on 03/10/2017.
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {
    void inject(MapsActivity fragment);

}